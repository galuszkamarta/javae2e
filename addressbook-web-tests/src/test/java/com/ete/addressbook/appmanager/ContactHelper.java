package com.ete.addressbook.appmanager;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.Contacts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
    attach(By.name("photo"), contactData.getPhoto());


    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
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


  public void selectContactById(int id) {
    driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }


  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    Alert alert = driver.switchTo().alert();
    alert.accept();
    click(By.linkText("home"));
  }


  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(ContactData contact, boolean b) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    click(By.linkText("home"));
  }


  public boolean isThereAConact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return driver.findElements(By.name("selected[]")).size();
  }

  public Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
              .withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones));
    }
    return new Contacts(contactCache);
  }


  public ContactData infoFromEditFrom(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
    String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
    String address = driver.findElement(By.name("address")).getAttribute("value");
    String email = driver.findElement(By.name("email")).getAttribute("value");
    String email2 = driver.findElement(By.name("email2")).getAttribute("value");
    String email3 = driver.findElement(By.name("email3")).getAttribute("value");

    String home = driver.findElement(By.name("home")).getAttribute("value");
    String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
    String work = driver.findElement(By.name("work")).getAttribute("value");
    driver.navigate().back();

    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

    //driver.findElement(By.xpath(String.format("//input[@value='%s'/../../td[8]/a", id))).click();
    //driver.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    //driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s", id))).click();
  }

  public String infoFromDetailsPage(ContactData contact) {
    initContactDetailsById(contact.getId());
    String contactDetails = driver.findElement(By.xpath("//div[@id='content']/br")).getAttribute("textContent");
//    String contactDetails = driver.findElement(By.cssSelector("#content")).getAttribute("textContent");

    driver.navigate().back();

    return contactDetails;
  }

  private void initContactDetailsById(int id) {
    WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(6).findElement(By.tagName("a")).click();
  }

}


