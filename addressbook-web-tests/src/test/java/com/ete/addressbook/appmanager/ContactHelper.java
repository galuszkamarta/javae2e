package com.ete.addressbook.appmanager;

import com.ete.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by g on 2019-10-24.
 */
public class ContactHelper  extends HelperBase {

  public ContactHelper(FirefoxDriver driver) {
    super(driver);
  }
  public void fillContactForm(ContactData contactData){
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("email"), contactData.getEmail());
  }

  public void submitContactCreation() {
    click(By.xpath("//input[@value='Enter']"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@title='Edit']//parent::a"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContact() {
    click(By.xpath("//input[@name='selected[]']"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }
}
