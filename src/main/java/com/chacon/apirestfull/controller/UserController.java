package com.chacon.apirestfull.controller;

import com.chacon.apirestfull.dto.user.request.UserDto;
import com.chacon.apirestfull.dto.user.request.UserLogin;
import com.chacon.apirestfull.dto.user.response.UserToken;
import com.chacon.apirestfull.model.User;
import com.chacon.apirestfull.service.auth.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/api/user")
public class UserController {
   
    @Autowired
    Authentication authorization;

    @PostMapping(value="register")
    public User register(@RequestBody UserDto userDto){
        return authorization.register(userDto);
    }

    @PostMapping(value="login")
    public UserToken login(@RequestBody UserLogin userDto){
        return authorization.login(userDto);
    }

    // @GetMapping(value="status")
    // public String userStatus(@RequestHeader(value="Authorization") String authToken, HttpServletRequest request){
    //     return authorization.status(authToken);
    //     // return authToken;
    // }
}
