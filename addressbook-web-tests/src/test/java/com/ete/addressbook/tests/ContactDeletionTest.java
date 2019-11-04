package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by m on 2019-10-24.
 */
public class ContactDeletionTest extends TestBase {
  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    if(! app.getContactHelper().isThereAConact()) {
      app.getContactHelper().createContact(new ContactData("marta", "ggg", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
//    app.getContactHelper().returnToHomePage();
  }
}
