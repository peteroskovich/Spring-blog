package com.ashop.shop.controllers;

import com.ashop.shop.models.Book;
import com.ashop.shop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String greeting(Model model) {
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
//        model.addAttribute("name", name);
        model.addAttribute("name", "home page");
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
        return "redirect:/";
    }

    @GetMapping("/support")
    public String support(Model model) {
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)

//        model.addAttribute("name", name);
        model.addAttribute("name", "Di noi");
        return "support";
    }


}