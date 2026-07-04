package com.vendex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JPA Configuration
 * Enables Spring Data JPA repositories and multi-tenant support
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.vendex.repository")
public class JpaConfig {
}
