package dev.alfrendosilalahi.project.phonebook.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDetailResponseDTO {

    private ContactDetailDTO contact;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ContactDetailDTO {

        private String id;

        private String name;

        private String phoneNumber;

        private String email;

        private String address;

        private String notes;

        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;

    }

}
