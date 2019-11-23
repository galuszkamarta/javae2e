package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by m on 2019-10-24.
 */
public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation (){
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("fafa").withLastName("fwafa").withGroup("test1");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();

    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
