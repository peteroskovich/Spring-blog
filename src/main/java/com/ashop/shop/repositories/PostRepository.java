package com.ashop.shop.repositories;

import com.ashop.shop.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
