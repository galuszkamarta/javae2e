package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.Contacts;
import com.ete.addressbook.model.GroupData;
import com.ete.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by m on 2019-10-24.
 */
public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Pola").withLastName("G").withGroup("test1"), true);
    }
  }

  @Test //(enabled = false)
  public void testContactDeletion() {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}



