package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by m on 2019-10-24.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("marta").withLastName("ggg").withGroup("test1"), true);
    }
  }

  @Test
  public void TestContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
           .withId(modifiedContact.getId()).withFirstName("marta").withLastName("ggg").withGroup("test2");
    app.contact().modify(contact, false);
    Set<ContactData> after = app.contact().all();

    assertEquals(after.size(), before.size());
    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}















