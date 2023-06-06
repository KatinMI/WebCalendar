package com.web.WebCalendar.util;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class CriptoTest {
    private Cripto cripto = new Cripto("MD5");
    private static MessageDigest md;
    @BeforeAll
    public static void init(){
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void getPassHash() throws UnsupportedEncodingException {
        byte[] bytesOfMessage = "123".getBytes("UTF-8");
        byte[] hash = md.digest(bytesOfMessage);
        BigInteger bigInteger = new BigInteger(1, hash);
        String text = bigInteger.toString(16);
        Assertions.assertEquals(text,cripto.getPassHash("123"));
    }
}