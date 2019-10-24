package com.ete.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by m on 2019-10-24.
 */
public class ContactDeletionTest extends TestBase {
  @Test
  public void testContactDeletion() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
  }
}
