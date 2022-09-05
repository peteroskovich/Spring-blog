package com.ashop.shop.repositories;

import com.ashop.shop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    int x = 10;
}