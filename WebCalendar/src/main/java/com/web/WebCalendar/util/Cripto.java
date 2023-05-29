package com.web.WebCalendar.util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.*;
@Component
public class Cripto {
    MessageDigest md;

    public Cripto(@Value("MD5") String algorithm){
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public String getPassHash(String pass) {
            md.reset();
            md.update(pass.getBytes());
            byte[] byt = md.digest();
            BigInteger bigInteger = new BigInteger(1, byt);
            String hash = bigInteger.toString(16);
            return hash;
    }
}
