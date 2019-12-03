package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.Contacts;
import com.ete.addressbook.model.GroupData;
import com.ete.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by m on 2019-10-24.
 */
public class ContactCreationTest extends TestBase {



  @Test //(enabled = false)
  public void testContactCreation() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().withFirstName("fafa").withLastName("fwafa").withPhoto(photo).withGroup("test1");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();

    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
