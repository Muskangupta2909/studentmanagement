package com.Project.studentmanagement.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {

        super(message); //custom error if student not found throw
    }
}