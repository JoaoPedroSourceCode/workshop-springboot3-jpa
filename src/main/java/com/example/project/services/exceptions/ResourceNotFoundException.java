package com.example.project.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public static final long serialVersionUID = 1L;

    public ResourceNotFoundException (Object id) {
        super ("Resource not Found. Id: " + id);
    }
}
