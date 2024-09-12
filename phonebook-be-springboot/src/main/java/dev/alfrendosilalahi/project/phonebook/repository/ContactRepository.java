package dev.alfrendosilalahi.project.phonebook.repository;

import dev.alfrendosilalahi.project.phonebook.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {

    /**
     * Find all contacts with name containing the given name, and then return result
     * as a page of contacts.
     *
     * @param name name to search
     * @param pageable page information
     * @return a page of contacts
     */
    Page<Contact> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
