package com.chacon.apirestfull.controller;

import com.chacon.apirestfull.dto.user.request.UserDto;
import com.chacon.apirestfull.model.User;
import com.chacon.apirestfull.service.Authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/api/user")
public class UserController {
   
    @Autowired
    Authorization authorization;

    @PostMapping(value="register")
    public User salveProduct(@RequestBody UserDto userDto){
        return authorization.register(userDto);
    }
}
