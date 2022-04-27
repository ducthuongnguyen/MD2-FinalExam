package service;

import model.Contact;

import java.util.ConcurrentModificationException;
import java.util.List;

public interface IContactService {
    List<Contact> findAll();

    void save(Contact contact);

    void updateContact(String phoneNumber, String newGroup, String newName, String newGender, String newAddress, String newDate, String newEmail);

    void deleteContact(String phoneNumber);

    List<Contact> searchByName(String name);

    List<Contact> searchByPhoneNumber(String phone);
}
