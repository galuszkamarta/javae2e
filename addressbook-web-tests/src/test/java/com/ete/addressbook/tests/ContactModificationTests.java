package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by m on 2019-10-24.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    if(!app.getContactHelper().isThereAConact()) {
      app.getContactHelper().createContact(new ContactData("marta", "ggg", "test1"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("marta", "ggg", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }

}
