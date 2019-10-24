package com.ete.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by m on 2019-10-22.
 */
public class NavigationHelper extends HelperBase {
  private FirefoxDriver driver;

  public NavigationHelper(FirefoxDriver driver) {

    super(driver);
  }

  public void goToGroupPage() {

    click(By.linkText("groups"));
  }


  public void goToContactPage() {

    click(By.linkText("add new"));
  }


}