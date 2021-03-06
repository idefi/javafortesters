package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> contactsFromFile() throws IOException {
        return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
    }


    @Test(dataProvider = "contactsFromFile")
    public void testNonEmptyContactCreation(ContactData contact) throws Exception {

        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().createContact(contact);

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        //compare states
        assertThat(newList, equalTo(oldList.withAdded(contact)));
    }
}