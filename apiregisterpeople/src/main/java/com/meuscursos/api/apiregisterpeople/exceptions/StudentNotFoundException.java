package com.meuscursos.api.apiregisterpeople.exceptions;

public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(Long id) {
        super("Student not found with ID " + id);
    }

}
