package com.vendex.repository;

import com.vendex.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Audit Log Repository
 * Data access layer for AuditLog entity
 */
@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, UUID> {
    List<AuditLog> findByOrganizationId(UUID organizationId);
    List<AuditLog> findByUserId(UUID userId);
}
