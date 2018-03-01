package com.money.lava.deal.model.Login;

/**
 * Created by Mark on 9/16/15.
 */
public class User {

    private String username;
    private int type;

    public User (String username, int type) {
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public int getType() {
        return type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType(int type) {
        this.type = type;
    }
}
