package com.ete.addressbook.appmanager;

import com.ete.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by m on 2019-10-24.
 */
public class ContactHelper  extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void InitContactCreation() {

    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation){
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());


    if (creation) {
      new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
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
