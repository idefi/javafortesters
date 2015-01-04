package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

	@Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();


     //save old state
      List<ContactData> oldList = app.getContactHelper().getContacts();

     //actions
	app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname="afirst name";
    contact.lastname="last name";
    contact.address="address";
    contact.home="home";
    contact.mobile="moblie";
    contact.work="work";
    contact.email="email";
    contact.email2="email2";
    contact.bday="1";
    contact.bmonth="January";
    contact.byear="1999";
    contact.new_group="1";
    contact.address2="address2";
    contact.phone2="phone2";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().openMainPage();

     //save new state
      List<ContactData> newList = app.getContactHelper().getContacts();

      //compare states
      oldList.add(contact);
      Collections.sort(oldList);
      assertEquals(newList, oldList);
  }

}