package com.example.project.services.exceptions;

public class DataBaseException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public DataBaseException (String msg) {
        super(msg);
    }
}
