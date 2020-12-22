package com.chacon.apirestfull.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class CriptografaMD5 {
    
    public String md5(String password) {
        String md5 = null;
        
        if(null == password) return null;
        
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");
            
            digest.update(password.getBytes(), 0, password.length());
            
            md5 = new BigInteger(1,digest.digest()).toString(16);
        
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return md5;
    }
}
