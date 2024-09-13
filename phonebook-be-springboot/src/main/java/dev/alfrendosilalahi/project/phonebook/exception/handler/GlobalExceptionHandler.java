package dev.alfrendosilalahi.project.phonebook.exception.handler;

import dev.alfrendosilalahi.project.phonebook.dto.response.ErrorBaseResponseDTO;
import dev.alfrendosilalahi.project.phonebook.enums.ResStatus;
import dev.alfrendosilalahi.project.phonebook.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorBaseResponseDTO<Map<String, String>>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(ErrorBaseResponseDTO.<Map<String, String>>builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(ResStatus.ERROR.name())
                .message(errorMap)
                .build());
    }

}
