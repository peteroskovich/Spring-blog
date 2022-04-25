package com.ashop.shop.controllers.repositories;

import com.ashop.shop.controllers.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
