package com.ete.addressbook.appmanager;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by m on 2019-10-22.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {

    super(driver);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.xpath("//input[@value='New group']"));
  }

  public void deleteSelectedGroups() {

    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    driver.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }


  public void createGroup(GroupData group) {
   initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return driver.findElements(By.name("selected[]")).size();
  }
}

