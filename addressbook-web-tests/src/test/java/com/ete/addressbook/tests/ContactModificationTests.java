package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by m on 2019-10-24.
 */
public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAConact()) {
      app.getContactHelper().createContact(new ContactData("marta", "ggg", null), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    ContactData contactData = new ContactData(before.get(before.size() - 1).getId(), "test1", "test2", null);
    ContactData MartaGGGGG = new ContactData("marta", "ggg", "test1");
    app.getContactHelper().fillContactForm(MartaGGGGG, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contactData);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}










