package dev.alfrendosilalahi.project.phonebook.service.impl;

import dev.alfrendosilalahi.project.phonebook.dto.request.ContactRequestDTO;
import dev.alfrendosilalahi.project.phonebook.dto.response.ContactDetailResponseDTO;
import dev.alfrendosilalahi.project.phonebook.dto.response.ContactsResponseDTO;
import dev.alfrendosilalahi.project.phonebook.exception.ResourceNotFoundException;
import dev.alfrendosilalahi.project.phonebook.model.Contact;
import dev.alfrendosilalahi.project.phonebook.repository.ContactRepository;
import dev.alfrendosilalahi.project.phonebook.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    /**
     * Retrieves a page of contacts filtered by search query.
     * The contacts are sorted by the given sortBy and sortDir.
     * If the search query is empty, all contacts are returned.
     *
     * @param page     The page number to retrieve (1-indexed)
     * @param pageSize The page size to retrieve
     * @param sortBy   The column to sort by
     * @param sortDir  The sort direction (ASC or DESC)
     * @param search   The search query to filter by
     * @return A ContactsResponseDTO containing the contacts and pagination information
     */
    @Override
    public ContactsResponseDTO getContacts(int page, int pageSize, String sortBy, String sortDir, String search) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of((page - 1), pageSize, sort);
        Page<Contact> contactsPage;
        if (!search.isBlank()) {
            contactsPage = contactRepository.findByNameContainingIgnoreCase(search, pageable);
        } else {
            contactsPage = contactRepository.findAll(pageable);
        }
        return ContactsResponseDTO.builder()
                .contacts(contactsPage.getContent()
                        .stream()
                        .map(contact -> ContactsResponseDTO.ContactResponseDTO.builder()
                                .id(contact.getId())
                                .name(contact.getName())
                                .phoneNumber(contact.getPhoneNumber())
                                .build())
                        .toList())
                .lastPage(contactsPage.isLast())
                .page((contactsPage.getNumber() + 1))
                .build();
    }

    /**
     * Creates a new contact with the given data.
     * The contact id is auto-generated.
     *
     * @param contactRequestDTO The contact data to create
     */
    @Override
    @Transactional
    public void createContact(ContactRequestDTO contactRequestDTO) {
        Contact contact = Contact.builder()
                .id(UUID.randomUUID().toString())
                .name(contactRequestDTO.getName())
                .phoneNumber(contactRequestDTO.getPhoneNumber())
                .email(contactRequestDTO.getEmail())
                .notes(contactRequestDTO.getNotes())
                .address(contactRequestDTO.getAddress())
                .build();
        contactRepository.save(contact);
    }

    /**
     * Retrieves a contact by its id.
     *
     * @param id The contact id
     * @return The contact with the given id
     */
    @Override
    public ContactDetailResponseDTO getContactDetail(String id) {
        var contact = findContactById(id);
        return ContactDetailResponseDTO.builder()
                .contact(ContactDetailResponseDTO.ContactDetailDTO.builder()
                        .id(contact.getId())
                        .name(contact.getName())
                        .phoneNumber(contact.getPhoneNumber())
                        .email(contact.getPhoneNumber())
                        .address(contact.getAddress())
                        .notes(contact.getNotes())
                        .createdAt(contact.getCreatedAt())
                        .updatedAt(contact.getUpdatedAt())
                        .build())
                .build();
    }

    /**
     * Updates a contact with the given data.
     *
     * @param id            The contact id
     * @param contactRequestDTO The contact data to update
     */
    @Override
    @Transactional
    public void updateContact(String id, ContactRequestDTO contactRequestDTO) {
        var contact = findContactById(id);
        contact.setName(contactRequestDTO.getName());
        contact.setPhoneNumber(contactRequestDTO.getPhoneNumber());
        contact.setEmail(contactRequestDTO.getEmail());
        contact.setAddress(contactRequestDTO.getAddress());
        contact.setNotes(contactRequestDTO.getNotes());
        contactRepository.save(contact);
    }

    /**
     * Deletes a contact with the given id.
     *
     * @param id The contact id
     */
    @Override
    @Transactional
    public void deleteContact(String id) {
        var contact = findContactById(id);
        contactRepository.delete(contact);
    }

    /**
     * Finds a contact by its id.
     *
     * @param id The contact id
     * @return The contact with the given id
     * @throws ResourceNotFoundException If no contact with the given id is found
     */
    private Contact findContactById(String id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("contact", "id", id));
    }

}
