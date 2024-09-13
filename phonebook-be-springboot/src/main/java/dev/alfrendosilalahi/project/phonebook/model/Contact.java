package dev.alfrendosilalahi.project.phonebook.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "contact")
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String phoneNumber;

    private String email;

    private String address;

    private String notes;

}
