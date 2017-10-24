package com.sawyerd.ateamstest;

/**
 * Created by Dmitriy on 22.10.2017.
 */

public class Users {
    private String name;
    private String email;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private String phone;
    private String website;

    public Users(){

    }

    public Users(String name, String email, String street, String suite, String city, String zipcode, String phone, String website){
        this.name = name;
        this.email = email;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.phone = phone;
        this.website = website;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getStreet(){
        return street;
    }

    public String getSuite(){
        return suite;
    }

    public String getCity(){
        return city;
    }

    public String getZipcode(){
        return zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
