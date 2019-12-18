package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.Contacts;
import com.ete.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by m on 2019-10-24.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
         Groups groups = app.db().groups();
         File photo = new File("src/test/resources/stru.png");
         ContactData newContact = new ContactData().withFirstName("test_name").withLastName("test_surname").withPhoto(photo)
                 .inGroup(groups.iterator().next());
         app.contact().create(newContact, true);
       }
  }

  @Test
  public void TestContactModification() {
    app.group().groupCache = null;
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("marta").withLastName("ggg").withPhoto(photo)
            .inGroup(groups.iterator().next());
    app.contact().modify(contact, false);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyGroupLisyInUi();
  }

  public void verifyGroupLisyInUi() {
  }
}














