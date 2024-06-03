package com.example.kurumsalweb.controller;


import com.example.kurumsalweb.model.ContactModel;
import com.example.kurumsalweb.repository.ContactRepository;
import com.example.kurumsalweb.service.ContactService;
import com.example.kurumsalweb.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
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
    
    @Autowired
    private EmailSenderService senderService;
    
    
    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("ad") String ad, @RequestParam("mail") String mail,@RequestParam("telefon") String telefon) {
        ContactModel contact =new ContactModel();
        contact.setAd(ad);
        contact.setMail(mail);
        contact.setTelefon(telefon);
        contactRepository.save(contact);
        
        // E-posta gönderimi
        String subject = "Yeni İletişim Formu Alındı ! ";
        String body = "Ad: " + ad + "\nMail: " + mail + "\nTelefon: " + telefon;
        senderService.sendMail("bersanklc02@gmail.com", subject, body);
        
        
        return "redirect:/success.html";
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
