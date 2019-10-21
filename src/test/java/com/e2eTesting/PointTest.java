package com.e2eTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by g on 2019-10-16.
 */
public class PointTest {

  @Test
public void testArea(){
    Assert.assertEquals(DistanceBetweenTwoPoints.distance(), 6);
}
}
