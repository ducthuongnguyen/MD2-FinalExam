package config;

import model.Contact;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConfigReadAndWriteFile {
    public static final String PATH = "G:\\Code gym\\Module 2\\MD2-FinalExam\\src\\data\\contacts.txt";
    public List<Contact> readFromFile(String path){
        List<Contact> tList = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            tList = (List<Contact>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tList;
    }

    public void writeToFile(String path, List<Contact> tList){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(tList);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
