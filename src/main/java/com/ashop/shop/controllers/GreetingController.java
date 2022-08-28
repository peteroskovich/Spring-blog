package com.ashop.shop.controllers;

import com.ashop.shop.models.Book;
import com.ashop.shop.models.Post;
import com.ashop.shop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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
//        model.addAttribute("name", "home page");
        return "greeting";
    }

    @GetMapping("/book/add")
    public String bookAdd(Model model) {
        return "book-add";
    }


    @PostMapping("/book/add")
    public String bookPostAdd(@RequestParam String bookTitle, @RequestParam String description, @RequestParam String img) {
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

    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable(value = "id") long id, Model model) {
        if (!bookRepository.existsById(id)) {
            return "redirect:/book";
        }

        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book-details";
    }
    @GetMapping("/book/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!bookRepository.existsById(id)) {
            return "redirect:/book";
        }
        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book-edit";
    }

    @PostMapping("/book/{id}/edit")
    public String bookPostUpdate(@PathVariable(value = "id") long id, @RequestParam String bookTitle, @RequestParam String description, @RequestParam String img) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setBookTitle(bookTitle);
        book.setDescription(description);
        book.setImg(img);
        bookRepository.save(book);

        return "redirect:/";
    }

    @PostMapping("/book/{id}/remove")
    public String bookPostDelete(@PathVariable(value = "id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);

        return "redirect:/";

    }
}
