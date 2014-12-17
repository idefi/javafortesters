package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void modifySomeGroup () throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModification(1);
        ContactData contact = new ContactData();
        contact.firstname="new first name";
        contact.lastname="new last name";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
    }
}
