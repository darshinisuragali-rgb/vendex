package com.vendex.util;

/**
 * Application Constants
 */
public class Constants {

    // User Roles
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_USER = "USER";
    public static final String ROLE_APPROVER = "APPROVER";

    // User Status
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_INACTIVE = "INACTIVE";
    public static final String STATUS_SUSPENDED = "SUSPENDED";

    // Transaction Status
    public static final String TRANSACTION_PENDING = "PENDING";
    public static final String TRANSACTION_APPROVED = "APPROVED";
    public static final String TRANSACTION_REJECTED = "REJECTED";
    public static final String TRANSACTION_COMPLETED = "COMPLETED";
    public static final String TRANSACTION_FAILED = "FAILED";

    // Organization Status
    public static final String ORG_ACTIVE = "ACTIVE";
    public static final String ORG_INACTIVE = "INACTIVE";
    public static final String ORG_SUSPENDED = "SUSPENDED";

    // HTTP Status Messages
    public static final String SUCCESS = "Success";
    public static final String ERROR = "Error";
    public static final String NOT_FOUND = "Resource not found";
    public static final String UNAUTHORIZED = "Unauthorized access";
    public static final String BAD_REQUEST = "Invalid request";

    private Constants() {
        throw new AssertionError("Cannot instantiate Constants class");
    }
}
