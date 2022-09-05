package com.ashop.shop.repositories;

import com.ashop.shop.models.Book;
import com.ashop.shop.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
