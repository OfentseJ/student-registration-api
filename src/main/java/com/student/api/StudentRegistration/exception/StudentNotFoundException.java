package com.student.api.StudentRegistration.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student with ID " + id + " not found");
    }
}