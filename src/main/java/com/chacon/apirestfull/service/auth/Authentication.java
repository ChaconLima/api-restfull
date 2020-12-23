package com.chacon.apirestfull.service.auth;

import java.sql.Date;

import com.chacon.apirestfull.dto.user.request.UserDto;
import com.chacon.apirestfull.dto.user.request.UserLogin;
import com.chacon.apirestfull.dto.user.response.UserToken;
import com.chacon.apirestfull.model.User;
import com.chacon.apirestfull.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;



@Service
public class Authentication {
    
    @Autowired
    UserRepository userRepository;
    Token tokenServe = new Token();

    private boolean validateToken(String auth_token){
        try{
            String token = auth_token.replace("Bearer", "");
            Claims claims = tokenServe.decodeToken(token);
    
            System.out.println(claims.getIssuer());
            System.out.println(claims.getIssuedAt());
            System.out.println(claims.getExpiration());
            //verificação do token, se ja está expirado
            if(claims.getExpiration().before(new Date(System.currentTimeMillis()))){
                return false;
            }
    
            return true;
        } catch (Exception e) {
            return false;
        }
       

    }
    
    public String status(String auth_token){

        if(validateToken(auth_token))
        {
            return "conectado";
        }
        else
        {
            return "Não conectado";
        }
    }
    public User register( UserDto userDto){

        User user_request = new User();
        user_request = userDto.build();

        if( userRepository.findByemail(user_request.getEmail()) == null){
            return userRepository.save(user_request);
        }
        else{
            return userRepository.findByemail(user_request.getEmail());
        }
    }

    public UserToken login( UserLogin userDto){
        User user = new User();
        UserToken userToken= new UserToken();

        if(userRepository.findByemail(userDto.getEmail())==null){
            userToken.setEmail("Email não cadastrado");
            userToken.setPassword(" ... ");
            userToken.setToken(" ... ");
            return userToken;
        }
        else{
            user = userRepository.findByemail(userDto.getEmail());
            if( userDto.getPassword().equals(user.getPassword()))
            {
                userToken.setEmail(user.getEmail());
                userToken.setPassword(user.getPassword());
                userToken.setToken(tokenServe.generateToken(user));
                return userToken;
            }
            else
            {
                userToken.setEmail(user.getEmail());
                userToken.setPassword("Senha Errada");
                userToken.setToken(" ... ");
                return userToken;
            }
        }
    }
}
