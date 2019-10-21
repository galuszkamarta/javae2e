package com.e2eTesting;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by m on 2019-10-11.
 */
public class DistanceBetweenTwoPoints {
  public static double distance(){
    double x1 = 2;
    double y1 = 2;
    double x2 = 2;
    double y2 = -4;
    double potega = 2;

    double deltaX = x2 - x1;
    double absDeltaX = Math.abs(deltaX);
    double pierwiastekX = Math.pow(absDeltaX, potega);

    double deltaY = y2 - y1;
    double absDeltaY = Math.abs(deltaY);
    double pierwiastekY = Math.pow(absDeltaY, potega);

    double s = pierwiastekX + pierwiastekY;
    double odleglosc = Math.sqrt(s);
    
    return odleglosc;
  }

  public static void main(String[] args) {
    System.out.println(distance());
  }
}
