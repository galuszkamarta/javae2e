package com.ete.addressbook.appmanager;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.Contacts;
import com.ete.addressbook.model.GroupData;
import com.ete.addressbook.model.Groups;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

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

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());


    if (this.isElementPresent(By.name("new_group"))) {
      new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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


  public void selectContactById(int id) {
    driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }


  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    Alert alert = driver.switchTo().alert();
    alert.accept();
    click(By.linkText("home"));
  }


  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    click(By.linkText("home"));
  }


  /*public boolean isThereAConact() {
  return isElementPresent(By.xpath("//input[@name='selected[]']"));
  }
  public int getContactCount() {
    return driver.findElements(By.xpath("//input[@name='selected[]']")).size();
  }*/

  public boolean isThereAConact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String text = element.getText();
      List<String> words = new ArrayList<String>(Arrays.asList(text.split(" ")));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(words.get(0)).withLastName(words.get(1)).withGroup("test1"));
    }
    return new Contacts(contactCache);
  }
}

