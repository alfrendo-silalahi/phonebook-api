package dev.alfrendosilalahi.project.phonebook.controller;

import dev.alfrendosilalahi.project.phonebook.dto.request.ContactRequestDTO;
import dev.alfrendosilalahi.project.phonebook.dto.response.BaseResponseDTO;
import dev.alfrendosilalahi.project.phonebook.dto.response.ContactDetailResponseDTO;
import dev.alfrendosilalahi.project.phonebook.dto.response.ContactsResponseDTO;
import dev.alfrendosilalahi.project.phonebook.enums.ResStatus;
import dev.alfrendosilalahi.project.phonebook.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
@Slf4j
public class ContactController {

    private final ContactService contactService;

    /**
     * Get list of contacts with pagination, sorting, and searching.
     *
     * @param page     the page number, default is 1
     * @param pageSize the page size, default is 10
     * @param sortBy   the column to sort by, default is "name"
     * @param sortDir  the sort direction, default is "ASC"
     * @param search   the search keyword based on contact name, default is empty string
     * @return a response entity containing the list of contacts
     */
    @Operation(
            summary = "Get list of contacts with pagination, sorting, and searching based on contact name",
            description = "Get list of contacts with pagination, sorting, and searching based on contact name."
    )
    @GetMapping
    public ResponseEntity<BaseResponseDTO<ContactsResponseDTO>> getContacts(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize,
            @RequestParam(required = false, defaultValue = "name") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDir,
            @RequestParam(required = false, defaultValue = "") String search
    ) {
        var data = contactService.getContacts(page, pageSize, sortBy, sortDir, search);
        return ResponseEntity.ok(BaseResponseDTO.<ContactsResponseDTO>builder()
                .code(HttpStatus.OK.value())
                .status(ResStatus.SUCCESS.getName())
                .data(data)
                .build());
    }

    /**
     * Create a new contact.
     *
     * @param contactRequestDTO the contact request data transfer object
     * @return a response entity containing the success status
     */
    @Operation(
            summary = "Create a new contact",
            description = "Create a new contact."
    )
    @PostMapping
    public ResponseEntity<BaseResponseDTO<Void>> createContact(
            @RequestBody @Valid ContactRequestDTO contactRequestDTO
    ) {
        contactService.createContact(contactRequestDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponseDTO.<Void>builder()
                        .code(HttpStatus.CREATED.value())
                        .status(ResStatus.SUCCESS.getName())
                        .build());
    }

    /**
     * Get a contact by id.
     *
     * @param id the id of the contact
     * @return a response entity containing the contact detail
     */
    @Operation(
            summary = "Get a contact detail by id",
            description = "Get a contact detail by id."
    )
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDTO<ContactDetailResponseDTO>> getContactDetail(
            @PathVariable String id
    ) {
        var data = contactService.getContactDetail(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(BaseResponseDTO.<ContactDetailResponseDTO>builder()
                        .code(HttpStatus.OK.value())
                        .status(ResStatus.SUCCESS.getName())
                        .data(data)
                        .build());
    }

    /**
     * Update a contact by id.
     *
     * @param id                the id of the contact
     * @param contactRequestDTO the contact request data transfer object
     * @return a response entity containing success status
     */
    @Operation(
            summary = "Update a contact by id",
            description = "Update a contact by id."
    )
    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDTO<Void>> updateContact(
            @PathVariable String id,
            @RequestBody ContactRequestDTO contactRequestDTO
    ) {
        contactService.updateContact(id, contactRequestDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(BaseResponseDTO.<Void>builder()
                        .code(HttpStatus.OK.value())
                        .status(ResStatus.SUCCESS.getName())
                        .build());
    }

    /**
     * Delete a contact by id.
     *
     * @param id the id of the contact
     * @return a response entity containing success status
     */
    @Operation(
            summary = "Delete a contact by id",
            description = "Delete a contact by id."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDTO<Void>> deleteContact(
            @PathVariable String id
    ) {
        contactService.deleteContact(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(BaseResponseDTO.<Void>builder()
                        .code(HttpStatus.OK.value())
                        .status(ResStatus.SUCCESS.getName())
                        .build());
    }

}
