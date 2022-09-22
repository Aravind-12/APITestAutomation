package com.api.pojo;

import org.apache.juneau.annotation.Beanc;

import java.util.List;

public class Player {

    List<String> name;
    List<String> country;
    List<String> role;
    List<Integer> priceInCrores;

    @Beanc(properties = "name,country,role,priceInCrores")
    public Player(List<String> name, List<String> country, List<String> role, List<Integer> priceInCrores) {
        this.name = name;
        this.country = country;
        this.role = role;
        this.priceInCrores = priceInCrores;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public List<Integer> getPriceInCrores() {
        return priceInCrores;
    }

    public void setPriceInCrores(List<Integer> priceInCrores) {
        this.priceInCrores = priceInCrores;
    }

}
