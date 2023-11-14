package com.iluminaphb.main.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String id) {
        super("Resource not found. ID: "+id);
    }
}
