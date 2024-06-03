package com.example.kurumsalweb.controller;


import com.example.kurumsalweb.model.ContactModel;
import com.example.kurumsalweb.repository.ContactRepository;
import com.example.kurumsalweb.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private ContactService contactService;
    
    
    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("ad") String ad, @RequestParam("mail") String mail,@RequestParam("telefon") String telefon) {
        ContactModel contact =new ContactModel();
        contact.setAd(ad);
        contact.setMail(mail);
        contact.setTelefon(telefon);
        
        contactRepository.save(contact);
        return "/succes.html";
    }
    
    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }
    
   
    
    
    @GetMapping("/admin/contacts")
    @ResponseBody
    public List<ContactModel> getAllContacts() {
        return contactService.getAllContacts();
    }
    
    @DeleteMapping("admin/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
    }
}
