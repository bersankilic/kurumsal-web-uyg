package com.example.kurumsalweb.repository;

import com.example.kurumsalweb.model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactModel,Long> {
}
