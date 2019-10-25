package com.ete.addressbook.appmanager;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by m on 2019-10-22.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver driver) {

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
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='wada'])[7]/following::input[1]"));
  }

  public void deleteSelectedGroups() {

    click(By.name("delete"));
  }

  public void selectGroup() {

    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }


}

