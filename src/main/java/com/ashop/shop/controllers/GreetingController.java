package com.ashop.shop.controllers;

import com.ashop.shop.models.Book;
import com.ashop.shop.repositories.BookRepository;
import com.ashop.shop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class GreetingController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    /**
     * Handles the HTTP GET mapping request the list of created book posts
     * @return main page
     */

    @GetMapping("/")
    public String greeting(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);

        return "greeting";
    }

    @GetMapping("/book/add")
    public String bookAdd(Model model) {
        return "book-add";
    }


    /**
     * POST http request that saves Book object
     *  .addBook method  delegate to separate services in class BookService  instead using  bookRepository.save(book)
     * add the action instead of URL to method post
     * @param  file encapsulate the uploaded image by user into object of MultipartFile
     * @param bookTitle title of the book object
     * @param description description of book object
     * @return a redirection to the http request for the list of all book posts
     */

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

    /**
     * Handles the HTTP GET mapping request that show specific book post by its own id.
     * @return page with individual details of the book.
     */

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

    /**
     * Handles the HTTP GET mapping request that allow to edit a single book post
     * if post indicated by
     * @param id is not exist in database it will
     * @return redirect to all book
     * Use Optional to store the retrieved book object from database through postRepository
     * @return  redirect to edit sample page
     */

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

    /**
     * POST http request that  edit and saves the change of Book object
     * it set the new parameter to the retrieved object by id
     * @param id of book  object retrieved from the view template
     * @param  file encapsulate the uploaded image by user into object of MultipartFile
     * @param bookTitle title of the book object
     * @param description description of book object
     * @return a redirection to the main page
     */

    @PostMapping("/book/{id}/edit")
    public String bookPostUpdate(@PathVariable(value = "id") long id, @RequestParam("file") MultipartFile file, @RequestParam String bookTitle, @RequestParam String description) {
        bookService.editBook(id, file, bookTitle, description);
        return "redirect:/";
    }

    /**
     * POST http request that  delete the Post object  retrieved by id
     * from website and database
     * @param id of post  object retrieved from the view template
     * @param model encapsulates the  data that  present the book model with  its parameter
     * @return a redirection to the main page
     */


    @PostMapping("/book/{id}/remove")
    public String bookPostDelete(@PathVariable(value = "id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);

        return "redirect:/";

    }

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        System.out.println("Logging user login success...");

        return "greeting";
    }
}
