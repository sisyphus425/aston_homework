package ru.aston.homework.lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> phoneBook = new HashMap<>(); // ключ - фамилия; значение - список телефонов для этой фамилии

    // Добавление записи в справочник
    public void add(String lastName, String phoneNumber) {
        List<String> phones = phoneBook.get(lastName);
        if (phones == null) {
            phones = new ArrayList<>();
            phoneBook.put(lastName, phones);
        }
        phones.add(phoneNumber);
    }

    // Получение списка телефонов по фамилии
    public List<String> get(String lastName) {
        List<String> phones = phoneBook.get(lastName);
        if (phones == null) {
            return new ArrayList<>();
        }
        return phones;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавление записей для проверки
        phoneBook.add("Иванов", "+79131111111");
        phoneBook.add("Лужин", "+79132222222");
        phoneBook.add("Иванов", "+79133333333");
        phoneBook.add("Баранов", "+79134444444");

        // Поиск по фамилии Иванов
        List<String> ivanovPhones = phoneBook.get("Иванов");
        System.out.println("Телефоны Иванова:");
        for (String phone : ivanovPhones) {
            System.out.println(phone);
        }

        // Поиск по фамилии, которой нет в справочнике
        List<String> unknownPhones = phoneBook.get("Прохоров");
        System.out.println("Телефоны Прохорова:");
        if (unknownPhones.isEmpty()) {
            System.out.println("Записей не найдено.");
        }
    }
}


