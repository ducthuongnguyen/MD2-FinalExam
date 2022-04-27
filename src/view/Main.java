package view;

import model.Contact;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("------CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-------");
        System.out.println("Chọn chức năng theo số (để tiếp tục): ");
        System.out.println("1.Xem danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Đọc từ file");
        System.out.println("7.Ghi vào file");
        System.out.println("8.Thoát");
        choice = scanner.nextLine();
        switch (choice) {
            case "1":
                new ContactView().showContactList();
                break;
            case "2":
                new ContactView().formCreateContact();
                break;
            case "3":
                new ContactView().updateContact();
                break;
            case "4":
                new ContactView().deleteContact();
                break;
            case "5":
                new ContactView().search();
                break;
            default:
                System.err.println("Failed!Try again");
                new Main();
        }
    }
}
