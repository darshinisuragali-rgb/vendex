package com.vendex.repository;

import com.vendex.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Vendor Repository
 * Data access layer for Vendor entity
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {
    List<Vendor> findByOrganizationId(UUID organizationId);
}
