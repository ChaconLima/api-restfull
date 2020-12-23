package com.chacon.apirestfull.dto.user.response;

public class UserToken {
    private String email;
    private String password;
    private String token;

    // get
    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    //set
    public void setPassword(String password) {
        this.password = (password);
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
