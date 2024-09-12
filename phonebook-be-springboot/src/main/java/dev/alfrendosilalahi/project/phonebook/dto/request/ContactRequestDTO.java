package dev.alfrendosilalahi.project.phonebook.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequestDTO {

    private String name;

    private String phoneNumber;

    private String email;

    private String address;

    private String notes;

}
