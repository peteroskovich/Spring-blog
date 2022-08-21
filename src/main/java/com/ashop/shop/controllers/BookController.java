package com.ashop.shop.controllers;

import com.ashop.shop.models.Book;
import com.ashop.shop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Controller

public class BookController {

    @Autowired
    private BookRepository bookRepository;

//
//
//    @GetMapping("/greeting")
//    public String book(Model model) {
//        Iterable<Book> books = bookRepository.findAll();
//        model.addAttribute("books", books);
//        return "greeting";
//    }


    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");
    }
}




