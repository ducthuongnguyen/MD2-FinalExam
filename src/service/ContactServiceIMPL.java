package service;

import config.ConfigReadAndWriteFile;
import model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceIMPL implements IContactService {
    //    public List<Contact> contactList = new ConfigReadAndWriteFile().readFile("G:\\Code gym\\Module 2\\MD2-FinalExam\\src\\data\\contacts.csv");
    public List<Contact> contactList = new ConfigReadAndWriteFile().readFromFile(ConfigReadAndWriteFile.PATH);


    @Override
    public List<Contact> findAll() {
        new ConfigReadAndWriteFile().writeToFile(ConfigReadAndWriteFile.PATH, contactList);
//        new ConfigReadAndWriteFile().readFile("G:\\Code gym\\Module 2\\MD2-FinalExam\\src\\data\\contacts.csv");
        return contactList;
    }

    @Override
    public void save(Contact contact) {
        contactList.add(contact);
        findAll();
    }

    public boolean existContact(String phoneNumber) {
        for (int i = 0; i < contactList.size(); i++) {
            if (phoneNumber.equals(contactList.get(i).getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateContact(String phoneNumber, String newGroup, String newName, String newGender, String newAddress, String newDate, String newEmail) {
        boolean check = false;
        for (int i = 0; i < contactList.size(); i++) {
            if (phoneNumber.equalsIgnoreCase(contactList.get(i).getPhoneNumber())){
                contactList.get(i).setGroup(newGroup);
                contactList.get(i).setEmail(newEmail);
                contactList.get(i).setAddress(newAddress);
                contactList.get(i).setGender(newGender);
                contactList.get(i).setFullName(newName);
                contactList.get(i).setDateOfBirth(newDate);
                System.out.println("Cập nhật danh bạ thành công!!!");
                findAll();
                check = true;
            }
        }
        if (!check){
            System.err.println("Không tìm thấy ạ!!");
        }
    }

    @Override
    public void deleteContact(String phoneNumber) {
        for (int i = 0; i < contactList.size(); i++) {
            if (phoneNumber.equalsIgnoreCase(contactList.get(i).getPhoneNumber())){
                contactList.remove(i);
                System.out.println("Xóa thành công");
                findAll();
            }
        }
    }

    @Override
    public List<Contact> searchByName(String name) {
        List<Contact> resultList = new ArrayList<>();
        for (int i = 0; i < contactList.size(); i++) {
            if (name.equalsIgnoreCase(contactList.get(i).getFullName())){
                resultList.add(contactList.get(i));
            }
        }
        return resultList;
    }

    @Override
    public List<Contact> searchByPhoneNumber(String phone) {
        List<Contact> resultList = new ArrayList<>();
        for (int i = 0; i < contactList.size(); i++) {
            if (phone.equalsIgnoreCase(contactList.get(i).getPhoneNumber())){
                resultList.add(contactList.get(i));
            }
        }
        return resultList;
    }


}
