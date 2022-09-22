package com.api.pojo;

import org.apache.juneau.annotation.Beanc;

public class PlayerResponse {
    String name;
    String location;
    Player player;

    @Beanc(properties = "name,location,player")
    public PlayerResponse(String name, String location, Player player) {
        this.name = name;
        this.location = location;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
