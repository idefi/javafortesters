package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by idefi on 13.12.2014.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contact) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contact.address);
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(contact.home);
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(contact.mobile);
        driver.findElement(By.name("work")).clear();
        driver.findElement(By.name("work")).sendKeys(contact.work);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contact.email);
        driver.findElement(By.name("email2")).clear();
        driver.findElement(By.name("email2")).sendKeys(contact.email2);
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.bday);
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.bmonth);
//  driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(contact.byear);
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.new_group);
//   driver.findElement(By.name("address2")).clear();
        driver.findElement(By.name("address2")).sendKeys(contact.address2);
//   driver.findElement(By.name("phone2")).clear();
        driver.findElement(By.name("phone2")).sendKeys(contact.phone2);
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }
}