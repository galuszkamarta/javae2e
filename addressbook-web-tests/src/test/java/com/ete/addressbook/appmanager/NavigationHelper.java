package com.ete.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by m on 2019-10-22.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {

    super(driver);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && driver.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
      return;
    }
    click(By.linkText("groups"));
  }


  public void homePage() {
    if (isElementPresent(By.id("maintable"))) {
    return;
    }
    click(By.linkText("home"));
    }
  }

