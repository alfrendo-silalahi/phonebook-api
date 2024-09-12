package dev.alfrendosilalahi.project.phonebook.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorBaseResponseDTO<T> {

    private int code;

    private String status;

    private T message;

}
