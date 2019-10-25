package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by m on 2019-10-24.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("marta", "ggg", "Wood Street 1\nLiverpool\nN11 3NN", "79664529222", "mar@niepodam.com"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }

}
