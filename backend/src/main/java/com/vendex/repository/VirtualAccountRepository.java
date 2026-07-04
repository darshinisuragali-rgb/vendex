package com.vendex.repository;

import com.vendex.entity.VirtualAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Virtual Account Repository
 * Data access layer for VirtualAccount entity
 */
@Repository
public interface VirtualAccountRepository extends JpaRepository<VirtualAccount, UUID> {
    List<VirtualAccount> findByOrganizationId(UUID organizationId);
    Optional<VirtualAccount> findByAccountNumber(String accountNumber);
}
