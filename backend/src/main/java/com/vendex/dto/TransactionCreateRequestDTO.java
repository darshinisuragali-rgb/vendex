package com.vendex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Transaction Create Request DTO
 * Data transfer object for creating transactions
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionCreateRequestDTO {

    @NotNull(message = "Store ID cannot be null")
    private UUID storeId;

    @NotNull(message = "Vendor ID cannot be null")
    private UUID vendorId;

    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private String amount;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    private String currency = "INR";
}
