package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by m on 2019-11-22.
 */

public class ContactPhoneTests extends TestBase {

// @BeforeMethod
// public void ensurePreconditions() {
//        app.goTo().homePage();
//        if (app.contact().all().size() == 0) {
//        app.contact().create(new ContactData().withFirstName("Pola").withLastName("G"), true);
//        }
//        }

  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditFrom = app.contact().infoFromEditFrom(contact);

    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditFrom.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditFrom.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditFrom.getWorkPhone())));
  }

  public String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]", "");
  }
}
