package com.vendex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Store DTO
 * Data transfer object for Store entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreDTO {
    private UUID id;
    private UUID organizationId;
    private String name;
    private String location;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
