package com.ashop.shop.controllers.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

    public Post() {
    }

    //allows generating new field when adding a new article in blog
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

    private String title, announcement,full_text;
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String anons) {
        this.announcement = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
    public Post(String title, String announcement, String full_text) {
        this.title = title;
        this.announcement = announcement;
        this.full_text = full_text;
    }
}
