package com.ashop.shop.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecuredPasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String userPassword = "nim";
        String encodedPassword = encoder.encode(userPassword);

        String adminPassword = "dim";
        String encodedPassword1= encoder.encode(adminPassword);

        System.out.println(encodedPassword);
        System.out.println(encodedPassword1);
    }


}
