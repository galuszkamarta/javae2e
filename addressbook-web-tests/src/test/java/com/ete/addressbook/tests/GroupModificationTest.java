package com.ete.addressbook.tests;

import com.ete.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by m on 2019-10-24.
 */
public class GroupModificationTest extends TestBase {

  @Test
  public void TestGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

}
