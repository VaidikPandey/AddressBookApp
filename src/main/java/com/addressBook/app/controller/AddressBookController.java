package com.addressBook.app.controller;

import com.addressBook.app.dto.ContactDTO;
import com.addressBook.app.model.Contact;
import com.addressBook.app.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

	private final AddressBookService service;

	public AddressBookController(AddressBookService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Contact>> getAllContacts() {

		return ResponseEntity.ok(service.getAllContacts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable int id) {

		return ResponseEntity.ok(service.getContactById(id));
	}

	@PostMapping
	public ResponseEntity<Contact> createContact(@RequestBody ContactDTO dto) {

		Contact contact = service.addContact(dto);

		return ResponseEntity.status(201).body(contact);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable int id, @RequestBody ContactDTO dto) {

		return ResponseEntity.ok(service.updateContact(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable int id) {

		service.deleteContact(id);

		return ResponseEntity.ok("Contact deleted successfully");
	}
}