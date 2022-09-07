package com.ashop.shop.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecuredPasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "nim";
        String encodedPassword = encoder.encode(rawPassword);

        String rawPassword1 = "dim";
        String encodedPassword1= encoder.encode(rawPassword1);

        System.out.println(encodedPassword);
        System.out.println(encodedPassword1);
    }


}
