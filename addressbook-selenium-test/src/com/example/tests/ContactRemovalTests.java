package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact() {

        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size());
        app.getContactHelper().removeContact(index);

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        assertThat(newList, equalTo(oldList.without(index)));
    }
}