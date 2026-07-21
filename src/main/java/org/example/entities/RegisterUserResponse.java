package org.example.entities;

public class RegisterUserResponse {

    private String id;

    private String token;

    public String getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
