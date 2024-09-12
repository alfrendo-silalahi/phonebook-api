package dev.alfrendosilalahi.project.phonebook.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResStatus {

    SUCCESS("success"),
    ERROR("error");

    private final String name;

}
