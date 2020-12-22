package com.chacon.apirestfull.dto.user.request;

import com.chacon.apirestfull.model.User;
import com.chacon.apirestfull.service.CriptografaMD5;

public class UserDto {

    private String name;
    private String email;
    private String password;

    // get
    public String getName() {
        return name;
    }

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
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User build(){

        User user = new User();

        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);

        return user;
    }
    
}
