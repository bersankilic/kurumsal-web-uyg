package com.example.kurumsalweb.service;


import com.example.kurumsalweb.model.ContactModel;
import com.example.kurumsalweb.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    //
    @Autowired
    private ContactRepository contactRepository;
    
    public List<ContactModel> getAllContacts() {
        return contactRepository.findAll();
    }
    
    public void saveContact(ContactModel contact) {
        contactRepository.save(contact);
    }
    
    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }
    
}
