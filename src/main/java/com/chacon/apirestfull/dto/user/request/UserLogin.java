package com.chacon.apirestfull.dto.user.request;

import com.chacon.apirestfull.service.auth.CriptografaMD5;

public class UserLogin {

    private String email;
    private String password;

    // get
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    //set
    public void setPassword(String password) {
        CriptografaMD5 md5 = new CriptografaMD5();
        this.password = md5.md5(password);
        // this.password = (password);
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
