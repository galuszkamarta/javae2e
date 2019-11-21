package com.ete.addressbook.tests;

import com.ete.addressbook.model.GroupData;
import com.ete.addressbook.model.Groups;
import org.testng.annotations.Test;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by m on 2019-10-24.
 */
public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation (){
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("fafa").withLastName("fwafa").withGroup("test1");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat (after.size(), equalTo(before.size() + 1));
  }
}
