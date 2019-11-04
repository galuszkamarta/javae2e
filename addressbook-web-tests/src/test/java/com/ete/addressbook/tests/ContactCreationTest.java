package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by m on 2019-10-24.
 */
public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation (){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().InitContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("marta", "ggg", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
