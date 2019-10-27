package com.ete.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by m on 2019-10-22.
 */
public class NavigationHelper extends HelperBase {
  private WebDriver driver;

  public NavigationHelper(WebDriver driver) {

    super(driver);
  }

  public void goToGroupPage() {

    click(By.linkText("groups"));
  }


  public void goToContactPage() {

    click(By.linkText("add new"));
  }


}