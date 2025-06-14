package com.example.project.entities.resources.exceptions;

import com.example.project.services.exceptions.DataBaseException;
import com.example.project.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String error = "Resource not found";
        StandardError err = new StandardError(Instant.now(), httpStatus.value(), e.getMessage(), error, request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> integrityViolation(DataBaseException e, HttpServletRequest request) {

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String error = "Integrity Violation";
        StandardError err = new StandardError(Instant.now(), httpStatus.value(), e.getMessage(), error, request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(err);
    }
 }


