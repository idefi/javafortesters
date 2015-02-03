package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;

public class TestBase {

    protected ApplicationManager app;

    public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group : groups) {
            list.add(new Object[]{group});
        }
        return list;
    }

    public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (ContactData contact : contacts) {
            list.add(new Object[]{contact});
        }
        return list;
    }

    @BeforeTest
    public void setUp() throws Exception {
        String configFile = System.getProperty("configFile", "D:\\GitHub\\javafortesters\\addressbook-selenium-test\\src\\application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(new File("D:\\GitHub\\javafortesters\\addressbook-selenium-test\\src\\application.properties")));
        app = new ApplicationManager(properties);
    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() throws IOException {
        return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator() throws IOException {
        return wrapContactsForDataProvider(generateRandomContacts(5)).iterator();
    }
}