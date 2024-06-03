package com.example.kurumsalweb.service;


import com.example.kurumsalweb.model.AdminModel;
import com.example.kurumsalweb.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public AdminModel findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}
