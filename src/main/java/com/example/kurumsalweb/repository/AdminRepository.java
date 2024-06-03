package com.example.kurumsalweb.repository;

import com.example.kurumsalweb.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel, Long> {
    AdminModel findByEmail(String email);
}
