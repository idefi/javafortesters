package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
  public void testNonEmptyContactCreation() throws Exception {
	app.navigationHelper.openMainPage();
	app.contactHelper.initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname="first name";
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
    contact.firstname="phone2";
    app.contactHelper.fillContactForm(contact);
    app.contactHelper.submitContactCreation();
    app.navigationHelper.openHomePage();
  }

}