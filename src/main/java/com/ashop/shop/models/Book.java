package com.ashop.shop.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {
    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookTitle, description;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    //MEDIUMBLOB set the limit of 16MB of storage for the img column in database
    private String img;

    public Book(String bookTitle, String description, String img) {
        this.bookTitle = bookTitle;
        this.description = description;
        this.img = img;
    }


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


    @Override
    public String toString() {
        return "Book{" +
                "title='" + bookTitle + '\'' +
                ", description='" + description + '\'' +
                ", img=" + img +
                '}';
    }
}
