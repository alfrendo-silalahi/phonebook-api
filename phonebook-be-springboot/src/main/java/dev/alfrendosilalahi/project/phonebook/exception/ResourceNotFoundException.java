package dev.alfrendosilalahi.project.phonebook.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String entityName, String fieldName, String fieldValue) {
        super(String.format("%s with %s %s not found", entityName, fieldName, fieldValue));
    }

}
