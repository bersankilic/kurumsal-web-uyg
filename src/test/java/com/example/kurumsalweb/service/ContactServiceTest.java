package com.example.kurumsalweb.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.kurumsalweb.model.ContactModel;
import com.example.kurumsalweb.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class ContactServiceTest {


    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllContacts() {

        ContactModel contact1 = new ContactModel(1L, "Test-Name1", "testmail1@example.com","5550");
        ContactModel contact2 = new ContactModel(2L, "Test-Name2", "testmail2@example.com","5551");
        List<ContactModel> contacts = Arrays.asList(contact1, contact2);

        when(contactRepository.findAll()).thenReturn(contacts);


        List<ContactModel> result = contactService.getAllContacts();


        assertEquals(2, result.size());
        assertEquals("Test-Name1", result.get(0).getAd());
        assertEquals("Test-Name2", result.get(1).getAd());
    }

    @Test
    public void testSaveContact() {
        ContactModel contact = new ContactModel(1L, "Test-Name1", "testmail1@example.com","5550");

        contactService.saveContact(contact);

        verify(contactRepository, times(1)).save(contact);
    }

    @Test
    public void testDeleteContactById() {
        Long id = 1L;

        contactService.deleteContactById(id);

        verify(contactRepository, times(1)).deleteById(id);
    }
}
