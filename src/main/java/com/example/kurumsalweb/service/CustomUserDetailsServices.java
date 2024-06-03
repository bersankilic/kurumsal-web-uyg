package com.example.kurumsalweb.service;

import com.example.kurumsalweb.model.AdminModel;
import com.example.kurumsalweb.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailsServices implements UserDetailsService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AdminModel admin = adminRepository.findByEmail(email);
        if(admin == null){
            throw new UsernameNotFoundException("Email veya şifre bulunamadı");
        }
        return new CustomUserDetails(
                admin.getEmail(),
                admin.getPassword(),
                authorities()
        );
    }
    public Collection<? extends GrantedAuthority> authorities () {
        return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
    }
}
