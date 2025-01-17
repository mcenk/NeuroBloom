package com.mcenk.NeuroBloom.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<String> handleEntryNotFoundException(EntryNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
