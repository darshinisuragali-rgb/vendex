package com.vendex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * User DTO
 * Data transfer object for User entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private UUID id;
    private UUID organizationId;
    private UUID storeId;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    private String department;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
