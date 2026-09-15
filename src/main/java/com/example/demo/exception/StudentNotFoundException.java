package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StudentNotFoundException
        extends ResponseStatusException {

    public StudentNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND,
                "Student Not Found with id: " + id);
    }

}
