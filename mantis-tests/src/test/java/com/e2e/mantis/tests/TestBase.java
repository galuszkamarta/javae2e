package com.e2e.mantis.tests;

import org.openqa.selenium.remote.BrowserType;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.e2e.mantis.appmanager.ApplicationManager;

/**
 * Created by m on 2019-10-22.
 */
public class TestBase {


  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }
}