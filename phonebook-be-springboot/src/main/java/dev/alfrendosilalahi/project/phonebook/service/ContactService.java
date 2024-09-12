package dev.alfrendosilalahi.project.phonebook.service;

import dev.alfrendosilalahi.project.phonebook.dto.request.ContactRequestDTO;
import dev.alfrendosilalahi.project.phonebook.dto.response.ContactDetailResponseDTO;
import dev.alfrendosilalahi.project.phonebook.dto.response.ContactsResponseDTO;

public interface ContactService {

    ContactsResponseDTO getContacts(int page, int pageSize, String sortBy, String sortDir, String search);

    void createContact(ContactRequestDTO contactRequestDTO);

    ContactDetailResponseDTO getContactDetail(String id);

    void updateContact(String id, ContactRequestDTO contactRequestDTO);

    void deleteContact(String id);

}
