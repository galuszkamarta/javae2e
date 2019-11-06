package com.e2eTesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by m on 2019-11-05.
 */
public class Collections {
  public static void main(String[] args) {
    String[] langs = {"java", "C#"};

    for (String l : langs) {
      System.out.println("I would like to learn lang " + l + ".");
    }

    List<String> languages = Arrays.asList("Python", "PHP");

    for (String l : languages) {
      System.out.println("I would like to learn lang " + l + ".");
    }
  }
}
