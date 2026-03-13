package com.addressBook.app.service;

import com.addressBook.app.dto.ContactDTO;
import com.addressBook.app.exception.ContactNotFoundException;
import com.addressBook.app.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

	private List<Contact> contacts = new ArrayList<>();
	private int idCounter = 1;

	public List<Contact> getAllContacts() {
		return contacts;
	}

	public Contact getContactById(int id) {

		return contacts.stream().filter(contact -> contact.getId() == id).findFirst()
				.orElseThrow(() -> new ContactNotFoundException("Contact not found with id " + id));
	}

	public Contact addContact(ContactDTO dto) {

		Contact contact = new Contact();

		contact.setId(idCounter++);
		contact.setFirstName(dto.getFirstName());
		contact.setLastName(dto.getLastName());
		contact.setCity(dto.getCity());
		contact.setState(dto.getState());
		contact.setPhone(dto.getPhone());
		contact.setEmail(dto.getEmail());

		contacts.add(contact);

		return contact;
	}

	public Contact updateContact(int id, ContactDTO dto) {

		Contact contact = getContactById(id);

		contact.setFirstName(dto.getFirstName());
		contact.setLastName(dto.getLastName());
		contact.setCity(dto.getCity());
		contact.setState(dto.getState());
		contact.setPhone(dto.getPhone());
		contact.setEmail(dto.getEmail());

		return contact;
	}

	public void deleteContact(int id) {

		Contact contact = getContactById(id);

		contacts.remove(contact);
	}
}