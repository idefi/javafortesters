package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by idefi on 13.12.2014.
 */
public class NavigationHelper extends HelperBase{
    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        driver.get(manager.baseUrl + "/addressbookv4.1.4/");
    }

    public void openHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void gotoGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }
}
