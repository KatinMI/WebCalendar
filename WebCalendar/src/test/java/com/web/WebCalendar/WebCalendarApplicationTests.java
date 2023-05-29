package com.web.WebCalendar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;

@SpringBootTest
class WebCalendarApplicationTests {

	@Test
	void contextLoads() throws NoSuchAlgorithmException {
		String pass = "123456";
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.reset();
		md.update(pass.getBytes());
		byte[] byt = md.digest();
		BigInteger bigInteger = new BigInteger(1,byt);
		String hash = bigInteger.toString(16);
		System.out.println(hash);

		while (hash.length()< 32){
			hash = "0" + hash;

		}
		System.out.println(hash);
	}

}
