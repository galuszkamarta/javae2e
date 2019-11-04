package com.ete.addressbook.tests;

import com.ete.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
  }

}


