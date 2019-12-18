package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.Groups;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by m on 2019-10-24.
 */
public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/stru.png");
    ContactData newContact = new ContactData().withFirstName("test_name").withLastName("test_surname").withPhoto(photo)
            .inGroup(groups.iterator().next());
    app.contact().create(newContact, true);
    verifyGroupLisyInUi();
  }

  public void verifyGroupLisyInUi() {
  }


  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
