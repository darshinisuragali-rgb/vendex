package com.vendex.exception;

/**
 * Unauthorized Exception
 * Thrown when user is not authorized to perform an action
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
