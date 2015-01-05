package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
  public void testNonEmptyContactCreation(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();

     //save old state
      List<ContactData> oldList = app.getContactHelper().getContacts();

     //actions
      Random rnd = new Random();
	app.getContactHelper().initContactCreation();
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