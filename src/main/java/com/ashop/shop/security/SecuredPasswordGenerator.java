package com.ashop.shop.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecuredPasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String userPassword = "user";
        String encodedPassword = encoder.encode(userPassword);

        String adminPassword = "admin";
        String encodedPassword1= encoder.encode(adminPassword);

        System.out.println("---------user-------------"+encodedPassword);
        System.out.println("----------admin------------"+encodedPassword1);
    }


}
