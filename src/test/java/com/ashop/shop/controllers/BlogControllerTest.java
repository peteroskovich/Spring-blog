package com.ashop.shop.controllers;
import com.ashop.shop.models.Post;
import com.ashop.shop.repositories.PostRepository;
import com.ashop.shop.security.WebSecurityConfig;
import com.ashop.shop.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(value = BlogController.class,  excludeAutoConfiguration = {WebSecurityConfig.class})

class BlogControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @MockBean
    private PostRepository postRepository;




    @Test
    void blogPostAddParametersTest() throws Exception {

        Post post = new Post();
        post.setTitle("title_test");
        post.setAnnouncement("announcment_test");
        post.setFull_text("full_text_test");

        postRepository.save(post);

        assertEquals("title_test", post.getTitle());
        assertEquals("announcment_test", post.getAnnouncement());
        assertEquals("full_text_test", post.getFull_text());

    }
}