package com.chacon.apirestfull.service;

import com.chacon.apirestfull.dto.user.request.UserDto;
import com.chacon.apirestfull.model.User;
import com.chacon.apirestfull.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Authorization {
    
    @Autowired
    UserRepository userRepository;
    public User register( UserDto userDto){

        User user_request = new User();
        user_request = userDto.build();

        if( userRepository.findByemail(user_request.getEmail()) == null){
            return userRepository.save(user_request);
        }
        else
        {
            return userRepository.findByemail(user_request.getEmail());
        }
    }
}
