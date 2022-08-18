package com.ashop.shop.controllers;

import com.ashop.shop.models.Book;
import com.ashop.shop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("http://localhost:8080/")
    public String book(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "greeting";
    }

    @GetMapping("/book/add")
    public String bookAdd(Model model) {
        return "book-add";
    }


    @PostMapping("/book/add")
    public String blogPostAdd(@RequestParam String bookTitle, @RequestParam String description, @RequestParam String img) {
        Book book = new Book(bookTitle, description, img);
        bookRepository.save(book);
        return "redirect:http://localhost:8080/";
    }
}




