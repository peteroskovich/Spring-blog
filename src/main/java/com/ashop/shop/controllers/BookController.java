package com.ashop.shop.controllers;

import com.ashop.shop.models.Book;
import com.ashop.shop.repositories.BookRepository;
import com.ashop.shop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    /**
     * Handles the HTTP GET mapping request the list of created book posts
     * @return a redirection to the main page where all books showcase are shown
     */

    @GetMapping("/")
    public String greeting(@RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "12") int size,
                           Model model) {
//        Iterable<Book> books = bookRepository.findAll();
//        model.addAttribute("books", books);
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("books", bookPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", bookPage.getTotalPages());

        return "home";
    }

    @RequestMapping(value="books", method = RequestMethod.GET)
    public String listBooks(@RequestParam(name = "page", defaultValue = "0") int page,
                            @RequestParam(name = "size", defaultValue = "12") int size,
                            Model model) {
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("books", bookPage.getContent());
        model.addAttribute("page", page);
        model.addAttribute("totalPages", bookPage.getTotalPages());
        return "list";
    }

    @GetMapping("/book/add")
    public String bookAdd(Model model) {
        return "book-add";
    }


    @PostMapping("/book/add")
    public String bookPostAdd(@RequestParam("file") MultipartFile file, @RequestParam String bookTitle, @RequestParam String description) {

        //  instead   postRepository.save(post); delegate to separate services
        bookService.addBook(file, bookTitle, description);
        return "redirect:/";
    }

    @GetMapping("/support")
    public String support(Model model) {

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
    public String bookPostUpdate(@PathVariable(value = "id") long id, @RequestParam("file") MultipartFile file, @RequestParam String bookTitle, @RequestParam String description) {
        bookService.editBook(id, file, bookTitle, description);
        return "redirect:/";
    }

    @PostMapping("/book/{id}/remove")
    public String bookPostDelete(@PathVariable(value = "id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);

        return "redirect:/";

    }

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        System.out.println("Logging user login success...");

        return "home";
    }
}
