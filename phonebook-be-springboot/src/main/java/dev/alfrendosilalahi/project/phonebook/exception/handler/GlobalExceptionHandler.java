package dev.alfrendosilalahi.project.phonebook.exception.handler;

import dev.alfrendosilalahi.project.phonebook.dto.response.ErrorBaseResponseDTO;
import dev.alfrendosilalahi.project.phonebook.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorBaseResponseDTO<String>> handleResourceNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorBaseResponseDTO.<String>builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .status("error")
                        .message(e.getMessage())
                        .build());
    }

}
