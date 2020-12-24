package com.chacon.apirestfull.service.auth;

import java.util.Date;

import com.chacon.apirestfull.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Token {

    private final long expirationToken = 1800000;
    private String key = "authentication";

    public String generateToken(User user) {

        return Jwts.builder()
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setSubject(user.getEmail())
            .setExpiration(new Date(System.currentTimeMillis() + this.expirationToken))
            .signWith(SignatureAlgorithm.HS256, this.key)
            .compact();
    }
    public Claims decodeToken(String token){
        return Jwts.parser()
            .setSigningKey(this.key)
            .parseClaimsJws(token)
            .getBody();
    }
}
