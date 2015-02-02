package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    public static String generateRandomInt(int min, int max) {
        Random rnd = new Random();
        return String.valueOf(rnd.nextInt((max - min) + 1) + min);
    }

    @BeforeTest
    public void setUp() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader(new File("application.properties")));
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
    public Iterator<Object[]> randomValidContactGenerator() {
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 3; i++) {
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
                            //.withNew_group("1")
                    .withAddress2(generateRandomString())
                    .withPhone2(generateRandomString());
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

    public String generateRandomString() {
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0) {
            return "";
        } else {
            return "test" + rnd.nextInt();
        }
    }

    public String generateRandomMonth() {
        Random rnd = new Random();
        List<String> monthNames = Arrays.asList("-", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        return monthNames.get(rnd.nextInt(monthNames.size()));
    }
}