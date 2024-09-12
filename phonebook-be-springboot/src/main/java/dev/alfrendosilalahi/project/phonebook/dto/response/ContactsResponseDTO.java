package dev.alfrendosilalahi.project.phonebook.dto.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactsResponseDTO {

    private List<ContactResponseDTO> contacts;

    private boolean lastPage;

    private int page;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ContactResponseDTO {

        private String id;

        private String name;

        private String phoneNumber;

    }

}
