package com.vendex.repository;

import com.vendex.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Store Repository
 * Data access layer for Store entity
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, UUID> {
    List<Store> findByOrganizationId(UUID organizationId);
}
