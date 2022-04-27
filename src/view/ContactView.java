package view;

import controller.ContactController;
import model.Contact;
import service.ContactServiceIMPL;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ContactView {
    static Scanner scanner = new Scanner(System.in);
    //    List<Contact> contactList = new ArrayList<>();
    ContactServiceIMPL contactServiceIMPL = new ContactServiceIMPL();
    ContactController contactController = new ContactController();

    public void showContactList() {
        System.out.println(contactController.showContactList());
        backMenu();
    }

    private static void backMenu() {
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("ENTER \"QUIT\" TO COME BACK MENU: ");
            backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void formCreateContact() {
        System.out.println("Nhập số điện thoại:");
        String phone;
        while (true) {
            phone = scanner.nextLine();
            boolean checkPhone;
            checkPhone = Pattern.matches("^0[0-9]{8,9}$", phone);
            if (!checkPhone) {
                System.err.println("Failed!Try again!");
            } else {
                break;
            }
        }
        System.out.println("Nhập nhóm danh bạ:");
        String group = scanner.nextLine();
        System.out.println("Nhập tên đầy đủ:");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email;
        while (true) {
            email = scanner.nextLine();
            boolean checkEmail;
            checkEmail = Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", email);
            if (!checkEmail) {
                System.err.println("Failed!Try again!");
            } else {
                break;
            }
        }
        System.out.println("Nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        Contact contact = new Contact(phone, group, name, gender, address, dateOfBirth, email);
        contactController.creatContactForm(contact);
        backMenu();
    }

    public void updateContact() {
        System.out.println("Nhập số điện thoại bạn muốn cập nhật thông tin:");
        String phone = scanner.nextLine();
        if (!contactServiceIMPL.existContact(phone)) {
            System.err.println("Không có số này, nhập lại: ");
            updateContact();
        } else {
            System.out.println("Nhập mới nhóm danh bạ:");
            String group = scanner.nextLine();
            System.out.println("Nhập mới tên đầy đủ:");
            String name = scanner.nextLine();
            System.out.println("Nhập mới giới tính: ");
            String gender = scanner.nextLine();
            System.out.println("Nhập mới địa chỉ: ");
            String address = scanner.nextLine();
            System.out.println("Nhập mới email: ");
            String email;
            while (true) {
                email = scanner.nextLine();
                boolean checkEmail;
                checkEmail = Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", email);
                if (!checkEmail) {
                    System.err.println("Failed!Try again!");
                } else {
                    break;
                }
            }
            System.out.println("Nhập mới ngày sinh: ");
            String dateOfBirth = scanner.nextLine();
            contactController.updateContact(phone, group, name, gender, address, dateOfBirth, email);
            backMenu();
        }
    }

    public void deleteContact() {
        System.out.println("Nhập số điện thoại cần xóa: ");
        String phone = scanner.nextLine();
        if (!contactServiceIMPL.existContact(phone)) {
            System.err.println("Không có số này, nhập lại: ");
            deleteContact();
            backMenu();
        } else {
            System.out.println("Bạn có muốn xóa số này, nhập'Y' để xóa hoặc nhập phím bất kỳ để hủy: ");
            String confirmation = scanner.nextLine();
            if (confirmation.equals("Y")) {
                contactController.deleteContact(phone);
                backMenu();
            } else {
                backMenu();
            }
        }
    }

    public void search(){
        System.out.println("1.Tìm theo tên");
        System.out.println("2.Tìm theo số điện thoại");
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                System.out.println("Nhập tên cần tìm:");
                String name = scanner.nextLine();
                System.out.println( contactController.searchByName(name));
                backMenu();
                break;
            case "2":
                System.out.println("Nhập số điện thoại cần tìm: ");
                String phone = scanner.nextLine();
                System.out.println( contactController.searchByPhone(phone));
                backMenu();
                break;
            default:
                System.err.println("Try again!");
                search();
        }
    }

}
