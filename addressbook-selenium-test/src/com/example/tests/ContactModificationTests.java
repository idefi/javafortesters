package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void modifySomeGroup (ContactData contact) throws Exception {
        app.getNavigationHelper().openMainPage();

        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size());

        //actions
        app.getContactHelper().initContactModification(index);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().openMainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        oldList.set(index, contact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }
}