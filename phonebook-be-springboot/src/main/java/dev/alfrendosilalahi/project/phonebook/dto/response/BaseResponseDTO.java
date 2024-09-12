package dev.alfrendosilalahi.project.phonebook.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponseDTO<T> {

    private int code;

    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

}
