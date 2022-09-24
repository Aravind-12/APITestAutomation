package com.api.pojo;

import org.apache.juneau.annotation.Beanc;

import java.util.List;

public class PlayerResponse {

    private String name;
    private String location;
    private List<Player> player;

    @Beanc(properties = "name,location,player")
    public PlayerResponse(String name, String location, List<Player> player) {
        this.name = name;
        this.location = location;
        this.player = player;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
