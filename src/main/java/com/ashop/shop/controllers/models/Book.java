package com.ashop.shop.controllers.models;





import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Book implements Serializable {
    public Book(String bookTitle, String description, String img) {
        this.bookTitle = bookTitle;
        this.description = description;
        this.img = img;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false, updatable=false)
    private Long id;
    private String bookTitle;
    private  String description;


    private String img;
    @Column(nullable = false,updatable = false)
    private String bookCode;

    public Book(){}



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String title) {
        this.bookTitle = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + bookTitle + '\'' +
                ", description='" + description + '\'' +
                ", img=" + img +
                ", bookCode='" + bookCode + '\'' +
                '}';
    }
}
