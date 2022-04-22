package com.example.day07restapi.entities;

import com.google.gson.annotations.SerializedName;

public class User {
    private int id;
    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String name;
    private String bio;

    public User(int id, String login, String avatarUrl, String name, String bio) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
