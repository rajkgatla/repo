package com.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restservice.entity.Contact;
import com.restservice.repository.ContactRepository;


@RestController
@RequestMapping(path = "/contacts")
public class PhoneBookController {

	@Autowired
	private ContactRepository repository;

	@GetMapping
	public Iterable<Contact> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{surname}")
	public Contact find(@PathVariable("surname") String name) {
		return repository.findOne(name);
	}

	@PostMapping(consumes = "application/json")
	public Contact create(@RequestBody Contact contact) {
		return repository.save(contact);
	}

	@DeleteMapping(path = "/{surname}")
	public void delete(@PathVariable("surname") String surname) {
		repository.delete(surname);
	}

	@PutMapping(path = "/{surname}")
	public Contact update(@PathVariable("surname") String surname, @RequestBody Contact contact) {
		if (repository.exists(surname)) {
			contact.setSurname(surname);
			return repository.save(contact);
		} 
	}

}
