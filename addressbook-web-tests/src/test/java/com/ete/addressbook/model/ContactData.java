package com.ete.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String secondname;
  private String group;
  // private final String lastname;
 // private final String address;
 // private final String home;
  // private final String email;

  public ContactData(String firstname, String secondname, String group) {
    this.firstname = firstname;
    this.secondname = secondname;
    // this.lastname = lastname;
    // this.address = address;
    // this.home = home;
    // this.email = email;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return secondname;
  }

  public String getGroup(){return group;}

  /*public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

public String getEmail() {
    return email;
  }
 */
}
