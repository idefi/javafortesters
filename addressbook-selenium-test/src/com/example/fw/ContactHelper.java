package com.example.fw;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    private SortedListOf<ContactData> cachedContacts;

    public SortedListOf<ContactData> getContacts() {
        if (cachedContacts == null) {
            rebuildCache();
        }
        return new SortedListOf<ContactData>(cachedContacts);
    }

    private void rebuildCache() {
        cachedContacts = new SortedListOf<ContactData>();
        manager.navigateTo().mainPage();
        List<WebElement> entries = driver.findElements(By.name("entry"));
        for (WebElement entry : entries) {
            String firstname = entry.findElement(By.xpath(".//td[3]")).getText();
            String lastname = entry.findElement(By.xpath(".//td[2]")).getText();
            cachedContacts.add(new ContactData().withFirstname(firstname)
                    .withLastname(lastname));
        }
    }

    public ContactHelper createContact(ContactData contact) {
        manager.navigateTo().mainPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        rebuildCache();
        return this;
    }

    public ContactHelper modifyContact(ContactData contact, int index) {
        initContactModification(index);
        fillContactForm(contact);
        submitContactModification();
        rebuildCache();
        return this;
    }

    public ContactHelper removeContact(int index) {
        initContactModification(index);
        deleteContact();
        rebuildCache();
        return this;
    }

    //----------------------------------------------------------------


    public ContactHelper initContactCreation() {
        click(By.linkText("add new"));
        return this;
    }

    public ContactHelper fillContactForm(ContactData contact) {
            type(By.name("firstname"), contact.getFirstname());
            type(By.name("lastname"), contact.getLastname());
            type(By.name("address"), contact.getAddress());
            type(By.name("home"), contact.getHome());
            type(By.name("mobile"), contact.getMobile());
            type(By.name("work"), contact.getWork());
            type(By.name("email"), contact.getEmail());
            type(By.name("email2"), contact.getEmail2());
            selectByText(By.name("bday"), contact.getBday());
            selectByText(By.name("bmonth"), contact.getBmonth());
            type(By.name("byear"), contact.getByer());
            selectByText(By.name("new_group"), contact.getNew_group());
            type(By.name("address2"), contact.getAddress2());
            type(By.name("phone2"), contact.getPhone2());
            return this;
    }

    public ContactHelper submitContactCreation() {
        click(By.name("submit"));
        cachedContacts = null;
        return this;
    }

    public ContactHelper initContactModification(int index) {
        click(By.xpath("(//td[@class='center']/a[contains(@href,'edit.php')])[" + (index+1) + "]"));
        return this;
    }
    private ContactHelper selectContactByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
        return this;
        }

    public ContactHelper submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
        cachedContacts = null;
        return this;
        }

    public ContactHelper deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        cachedContacts = null;
        return this;
        }

    public String getMonth(int index) {
        List<String> months = new ArrayList<String>();
        List<WebElement> rows = driver.findElements(By.xpath("//select[@name='bmonth']/option[@value]"));
        System.out.println("Test number of elements: " + rows.size());
        for (WebElement row : rows) {
            String month;
            month = row.findElement(By.xpath(".//td[3]")).getText();
            months.add(month);
        }

        return months.get(index);
    }
}