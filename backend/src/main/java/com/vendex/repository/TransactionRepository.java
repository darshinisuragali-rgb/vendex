package com.vendex.repository;

import com.vendex.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Transaction Repository
 * Data access layer for Transaction entity
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    List<Transaction> findByOrganizationId(UUID organizationId);
    List<Transaction> findByStoreId(UUID storeId);
    List<Transaction> findByUserId(UUID userId);
    List<Transaction> findByStatus(String status);
}
