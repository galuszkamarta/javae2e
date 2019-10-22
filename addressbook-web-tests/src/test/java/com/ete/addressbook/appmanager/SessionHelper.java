package com.ete.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by m on 2019-10-22.
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(FirefoxDriver driver) {

    super(driver);
  }

  public void login(String username, String password) {
    type(By.name("user"),username);
    type(By.name("pass"),password);
    click(By.id("LoginForm"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]"));
  }
}