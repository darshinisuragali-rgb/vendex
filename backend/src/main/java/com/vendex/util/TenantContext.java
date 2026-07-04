package com.vendex.util;

import java.util.UUID;

/**
 * Tenant Context Holder
 * Maintains tenant information for multi-tenant data isolation
 */
public class TenantContext {

    private static final ThreadLocal<UUID> tenantId = new ThreadLocal<>();

    public static void setTenantId(UUID id) {
        tenantId.set(id);
    }

    public static UUID getTenantId() {
        return tenantId.get();
    }

    public static void clear() {
        tenantId.remove();
    }
}
