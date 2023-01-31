package com.spring.mvc;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;

    private String country;

    private String favouriteLanguage;

    private String[] operatingOS;

    private LinkedHashMap<String, String> countryOptions;

    public Student() {
        countryOptions = new LinkedHashMap<String, String>();
        countryOptions.put("BR","Brazil");
        countryOptions.put("FR","France");
        countryOptions.put("DE","Germany");
        countryOptions.put("IN","India");
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public String[] getOperatingOS() {
        return operatingOS;
    }

    public void setOperatingOS(String[] operatingOS) {
        this.operatingOS = operatingOS;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }
}
