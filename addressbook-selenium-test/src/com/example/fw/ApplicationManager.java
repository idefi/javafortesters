package com.example.fw;

import com.example.tests.GroupCreationTests;
import com.example.tests.TestBase;
import org.openqa.selenium.By;

/**
 * Created by nyu on 13.12.2014.
 */
public class ApplicationManager {
    public void returnToGroupsPage() {
        TestBase.driver.findElement(By.linkText("group page")).click();
    }

    public void returnToGroupsPage(GroupCreationTests groupCreationTests) {
    }

    public void submitGroupCreation() {
        TestBase.driver.findElement(By.name("submit")).click();
    }
}
