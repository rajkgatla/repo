package com.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.restservice.entity.Contact;

@RestResource(exported = false)
public interface ContactRepository extends JpaRepository<Contact, String> {

}
