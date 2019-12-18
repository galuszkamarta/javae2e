package com.ete.addressbook.tests;

import com.ete.addressbook.model.ContactData;
import com.ete.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by m on 2019-11-24.
 */
public class ContactEmailTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
  if (app.contact().all().size() == 0) {
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/stru.png");
    ContactData newContact = new ContactData().withFirstName("test_name").withLastName("test_surname").withPhoto(photo)
            .inGroup(groups.iterator().next());
    app.contact().create(newContact, true);
   }
  }


  @Test
  public void testContactEmails() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditFrom = app.contact().infoFromEditFrom(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditFrom)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}

