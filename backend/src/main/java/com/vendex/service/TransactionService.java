package com.vendex.service;

import com.vendex.dto.TransactionDTO;
import com.vendex.dto.TransactionCreateRequestDTO;
import com.vendex.entity.*;
import com.vendex.exception.ResourceNotFoundException;
import com.vendex.exception.BadRequestException;
import com.vendex.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Transaction Service
 * Business logic for transaction management and approval workflows
 */
@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    public TransactionDTO createTransaction(UUID userId, UUID organizationId, TransactionCreateRequestDTO request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new ResourceNotFoundException("Store", "id", request.getStoreId()));

        Vendor vendor = vendorRepository.findById(request.getVendorId())
                .orElseThrow(() -> new ResourceNotFoundException("Vendor", "id", request.getVendorId()));

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Organization", "id", organizationId));

        BigDecimal amount = new BigDecimal(request.getAmount());
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be greater than 0");
        }

        Transaction transaction = Transaction.builder()
                .organization(organization)
                .store(store)
                .user(user)
                .vendorId(vendor.getId())
                .amount(amount)
                .currency(request.getCurrency())
                .description(request.getDescription())
                .status("PENDING")
                .build();

        Transaction saved = transactionRepository.save(transaction);
        return mapToDTO(saved);
    }

    public TransactionDTO getTransactionById(UUID id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        return mapToDTO(transaction);
    }

    public List<TransactionDTO> getTransactionsByOrganization(UUID organizationId) {
        return transactionRepository.findByOrganizationId(organizationId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionsByStatus(String status) {
        return transactionRepository.findByStatus(status).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TransactionDTO approveTransaction(UUID id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        
        if (!transaction.getStatus().equals("PENDING")) {
            throw new BadRequestException("Only pending transactions can be approved");
        }
        
        transaction.setStatus("APPROVED");
        Transaction updated = transactionRepository.save(transaction);
        return mapToDTO(updated);
    }

    public TransactionDTO rejectTransaction(UUID id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id));
        
        if (!transaction.getStatus().equals("PENDING")) {
            throw new BadRequestException("Only pending transactions can be rejected");
        }
        
        transaction.setStatus("REJECTED");
        Transaction updated = transactionRepository.save(transaction);
        return mapToDTO(updated);
    }

    private TransactionDTO mapToDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .id(transaction.getId())
                .organizationId(transaction.getOrganization().getId())
                .storeId(transaction.getStore().getId())
                .userId(transaction.getUser().getId())
                .vendorId(transaction.getVendorId())
                .amount(transaction.getAmount().toString())
                .currency(transaction.getCurrency())
                .status(transaction.getStatus())
                .description(transaction.getDescription())
                .createdAt(transaction.getCreatedAt())
                .updatedAt(transaction.getUpdatedAt())
                .build();
    }
}
