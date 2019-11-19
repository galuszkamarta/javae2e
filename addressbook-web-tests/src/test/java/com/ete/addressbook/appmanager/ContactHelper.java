package com.ete.addressbook.appmanager;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 2019-10-24.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void initContactCreation() {

    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
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


  public void   deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));

  }



  public void createContact(ContactData contactData, boolean b) {
    initContactCreation();
    fillContactForm(contactData , b);
    submitContactCreation();
    returnToHomePage();
  }

  public void selectContact(int index) {
    driver.findElements(By.name("selected[]")).get(index).click();
  }


  /*public boolean isThereAConact() {
  return isElementPresent(By.xpath("//input[@name='selected[]']"));
  }
  public int getContactCount() {
    return driver.findElements(By.xpath("//input[@name='selected[]']")).size();
  }
*/
  public boolean isThereAConact() {
    return isElementPresent(By.name("selected[]"));
  }
  public int getContactCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element: elements) {
      String name = element.getText();
      String lastname = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contactData  = new ContactData(id, name, lastname, null);
      contacts.add(contactData);
    }
    return contacts;
  }
}


