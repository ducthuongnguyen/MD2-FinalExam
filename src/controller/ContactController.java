package controller;

import model.Contact;
import service.ContactServiceIMPL;

import java.util.List;

public class ContactController {
    ContactServiceIMPL contactServiceIMPL = new ContactServiceIMPL();

    public void creatContactForm(Contact contact) {
        contactServiceIMPL.save(contact);
        contactServiceIMPL.findAll();
    }
    public List<Contact> showContactList(){
        return contactServiceIMPL.findAll();
    }

    public void updateContact(String phoneNumber, String newGroup, String newName, String newGender, String newAddress, String newDate, String newEmail){
        contactServiceIMPL.updateContact(phoneNumber,newGroup,newName,newGender,newAddress,newDate,newEmail);
    }

    public void deleteContact(String phoneNumber){
        contactServiceIMPL.deleteContact(phoneNumber);
    }

    public List<Contact> searchByName(String name){
        return contactServiceIMPL.searchByName(name);
    }

    public List<Contact> searchByPhone(String phone){
        return contactServiceIMPL.searchByPhoneNumber(phone);
    }

}
