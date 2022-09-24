package com.api.pojo;


public class Player {
    private String name;
    private String country;
    private String role;
    private double priceInCrores;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getPriceInCrores(double v) {
        return priceInCrores;
    }

    public void setPriceInCrores(double priceInCrores) {
        this.priceInCrores = priceInCrores;
    }
}
