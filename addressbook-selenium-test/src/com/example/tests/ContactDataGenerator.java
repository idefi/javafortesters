package com.example.tests;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("Please specify parameters: <amount of testdata> <file> <format>");
            return;
        }
        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        if (file.exists()) {
            System.out.println("File exists, please remove it manually: " + file);
            return;
        }
        List<ContactData> contacts = generateRandomContacts(amount);
        if ("csv".equals(format)) {
            saveContactsToCsvFile(contacts, file);
        } else if ("xml".equals(format)) {
            saveContactsToXmlFile(contacts, file);
        } else {
            System.out.println("Unknown format " + format);
            return;
        }
    }

    private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("contact", ContactData.class);
        String xml = xstream.toXML(contacts);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    public static List<ContactData> loadContactsFromXmlFile(File file) {
        XStream xstream = new XStream();
        xstream.alias("contact", ContactData.class);
        return (List<ContactData>) xstream.fromXML(file);
    }

    private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress()
                    + "," + contact.getHome() + "," + contact.getMobile() + "," + contact.getWork()
                    + "," + contact.getEmail() + "," + contact.getEmail2() + "," + contact.getBday()
                    + "," + contact.getBmonth() + "," + contact.getByer() + "," + contact.getAddress2()
                    + "," + contact.getPhone2() + ",!" + "\n");
        }
        writer.close();
    }

    public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
        List<ContactData> list = new ArrayList<ContactData>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] part = line.split(",");
            ContactData contact = new ContactData()
                    .withFirstname(part[0])
                    .withLastname(part[1])
                    .withAddress(part[2])
                    .withHome(part[3])
                    .withMobile(part[4])
                    .withWork(part[5])
                    .withEmail(part[6])
                    .withEmail2(part[7])
                    .withEmail2(part[8])
                    .withBday(part[9])
                    .withBmonth(part[10])
                    .withByear(part[11])
                    .withAddress2(part[12])
                    .withPhone2(part[13]);
            list.add(contact);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return list;
    }

    public static List<ContactData> generateRandomContacts(int amount) {
        List<ContactData> list = new ArrayList<ContactData>();
        for (int i = 0; i < amount; i++) {
            ContactData contact = new ContactData()
                    .withFirstname(generateRandomString())
                    .withLastname(generateRandomString())
                    .withAddress(generateRandomString())
                    .withHome(generateRandomString())
                    .withMobile(generateRandomString())
                    .withWork(generateRandomString())
                    .withEmail(generateRandomString())
                    .withEmail2(generateRandomString())
                    .withBday(generateRandomInt(1, 31))
                    .withBmonth(generateRandomMonth())
                    .withByear(generateRandomInt(1900, 2015))
                    .withAddress2(generateRandomString())
                    .withPhone2(generateRandomString());
            list.add(contact);
        }
        return list;
    }

    public static String generateRandomString() {
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0) {
            return "";
        } else {
            return "test" + rnd.nextInt();
        }
    }

    public static String generateRandomMonth() {
        Random rnd = new Random();
        List<String> monthNames = Arrays.asList("-", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        return monthNames.get(rnd.nextInt(monthNames.size()));
    }

    public static String generateRandomInt(int min, int max) {
        Random rnd = new Random();
        return String.valueOf(rnd.nextInt((max - min) + 1) + min);
    }
}