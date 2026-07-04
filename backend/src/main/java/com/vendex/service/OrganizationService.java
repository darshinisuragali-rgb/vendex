package com.vendex.service;

import com.vendex.dto.OrganizationDTO;
import com.vendex.entity.Organization;
import com.vendex.exception.ResourceNotFoundException;
import com.vendex.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Organization Service
 * Business logic for organization management
 */
@Service
@Transactional
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationDTO createOrganization(OrganizationDTO dto) {
        Organization organization = Organization.builder()
                .name(dto.getName())
                .industry(dto.getIndustry())
                .countryCode(dto.getCountryCode())
                .timezone(dto.getTimezone())
                .status("ACTIVE")
                .build();
        Organization saved = organizationRepository.save(organization);
        return mapToDTO(saved);
    }

    public OrganizationDTO getOrganizationById(UUID id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization", "id", id));
        return mapToDTO(organization);
    }

    public OrganizationDTO updateOrganization(UUID id, OrganizationDTO dto) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization", "id", id));
        
        if (dto.getName() != null) organization.setName(dto.getName());
        if (dto.getIndustry() != null) organization.setIndustry(dto.getIndustry());
        if (dto.getCountryCode() != null) organization.setCountryCode(dto.getCountryCode());
        if (dto.getTimezone() != null) organization.setTimezone(dto.getTimezone());
        
        Organization updated = organizationRepository.save(organization);
        return mapToDTO(updated);
    }

    public List<OrganizationDTO> getAllOrganizations() {
        return organizationRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void deleteOrganization(UUID id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization", "id", id));
        organizationRepository.delete(organization);
    }

    private OrganizationDTO mapToDTO(Organization organization) {
        return OrganizationDTO.builder()
                .id(organization.getId())
                .name(organization.getName())
                .industry(organization.getIndustry())
                .countryCode(organization.getCountryCode())
                .timezone(organization.getTimezone())
                .status(organization.getStatus())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .build();
    }
}
