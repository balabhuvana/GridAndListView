package com.example.balamurugan_se.gridandlistview.model;

/**
 * Created by balamurugan_se on 6/28/2016.
 */
public class AddressModel<T> {
    private String doorNo;
    private String streetName;
    private String city;
    private String state;

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
