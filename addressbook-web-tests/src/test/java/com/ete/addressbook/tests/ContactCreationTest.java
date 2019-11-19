package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by m on 2019-10-24.
 */
public class ContactCreationTest extends TestBase {

  @Test(enabled = false)
  public void testContactCreation (){
    app.goTo().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();

    ContactData contactData = new ContactData("marta", "ggg", "test1");
    app.getContactHelper().createContact(contactData, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contactData);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}


