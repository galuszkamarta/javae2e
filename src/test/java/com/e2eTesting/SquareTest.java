package com.e2eTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by g on 2019-10-16.
 */
public class SquareTest {

  @Test
  public void testArea() {
    Square s = new Square (5);
    Assert.assertEquals(s.area(), 25.0);
  }
}
