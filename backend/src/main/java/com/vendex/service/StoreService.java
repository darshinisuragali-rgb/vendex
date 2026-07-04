package com.vendex.service;

import com.vendex.dto.StoreDTO;
import com.vendex.entity.Organization;
import com.vendex.entity.Store;
import com.vendex.exception.ResourceNotFoundException;
import com.vendex.repository.OrganizationRepository;
import com.vendex.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Store Service
 * Business logic for store management
 */
@Service
@Transactional
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    public StoreDTO createStore(UUID organizationId, StoreDTO dto) {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Organization", "id", organizationId));

        Store store = Store.builder()
                .organization(organization)
                .name(dto.getName())
                .location(dto.getLocation())
                .status("ACTIVE")
                .build();

        Store saved = storeRepository.save(store);
        return mapToDTO(saved);
    }

    public StoreDTO getStoreById(UUID id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store", "id", id));
        return mapToDTO(store);
    }

    public List<StoreDTO> getStoresByOrganization(UUID organizationId) {
        return storeRepository.findByOrganizationId(organizationId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public StoreDTO updateStore(UUID id, StoreDTO dto) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store", "id", id));

        if (dto.getName() != null) store.setName(dto.getName());
        if (dto.getLocation() != null) store.setLocation(dto.getLocation());
        if (dto.getStatus() != null) store.setStatus(dto.getStatus());

        Store updated = storeRepository.save(store);
        return mapToDTO(updated);
    }

    public void deleteStore(UUID id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store", "id", id));
        storeRepository.delete(store);
    }

    private StoreDTO mapToDTO(Store store) {
        return StoreDTO.builder()
                .id(store.getId())
                .organizationId(store.getOrganization().getId())
                .name(store.getName())
                .location(store.getLocation())
                .status(store.getStatus())
                .createdAt(store.getCreatedAt())
                .updatedAt(store.getUpdatedAt())
                .build();
    }
}
