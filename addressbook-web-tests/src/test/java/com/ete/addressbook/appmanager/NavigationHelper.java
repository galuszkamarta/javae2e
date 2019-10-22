package com.ete.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by g on 2019-10-22.
 */
public class NavigationHelper {
  private FirefoxDriver driver;

  public NavigationHelper(FirefoxDriver driver) {
    this.driver = driver;
  }

  public void goToGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }
}