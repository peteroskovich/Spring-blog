package com.ashop.shop.services;

import com.ashop.shop.models.Book;
import com.ashop.shop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    public Book addBook(MultipartFile file, String bookTitle, String description) {
        Book book = new Book();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            book.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        book.setDescription(description);
        book.setBookTitle(bookTitle);
        return bookRepository.save(book);
    }


    public Book editBook(@PathVariable(value = "id") long id, @RequestParam MultipartFile file, @RequestParam String bookTitle, @RequestParam String description){
        Book book = bookRepository.findById(id).orElseThrow();
        book.setBookTitle(bookTitle);
        book.setDescription(description);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            book.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
       return bookRepository.save(book);
    }
}