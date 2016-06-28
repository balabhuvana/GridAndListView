package com.example.balamurugan_se.gridandlistview.model;

/**
 * Created by balamurugan_se on 6/28/2016.
 */
public class NameModel<T> {
    private String firstName;
    private String lastName;
    private String petName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
