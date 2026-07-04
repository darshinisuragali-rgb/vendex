package com.vendex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Organization DTO
 * Data transfer object for Organization entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationDTO {
    private UUID id;
    private String name;
    private String industry;
    private String countryCode;
    private String timezone;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
