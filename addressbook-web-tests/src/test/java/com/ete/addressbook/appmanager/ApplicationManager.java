package com.ete.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by m on 2019-10-22.
 */
public class ApplicationManager {
  FirefoxDriver driver;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public void init() {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    driver.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}