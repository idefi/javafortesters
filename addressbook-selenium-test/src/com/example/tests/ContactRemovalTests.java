package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup () {
        app.getNavigationHelper().openMainPage();


        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size());

        //actions
        app.getContactHelper().initContactModification(index);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().openMainPage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}