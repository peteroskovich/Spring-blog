package com.ashop.shop.controllers;

import com.ashop.shop.models.Post;
import com.ashop.shop.repositories.PostRepository;
import com.ashop.shop.security.WebSecurityConfig;
import com.ashop.shop.services.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(value = BlogController.class)
// excludeAutoConfiguration = {WebSecurityConfig.class}
class BlogControllerTest  {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @MockBean
    private PostRepository postRepository;


    @Test
    @WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
    void blogTest() throws Exception {
        this.mockMvc
                .perform(get("/blog"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("posts"))
                .andExpect(view().name("blog"));
    }

    @Test
    void blogPostAddParametersTest()  {

        Post post = new Post();
        post.setTitle("title_test");
        post.setAnnouncement("announcment_test");
        post.setFull_text("full_text_test");

        postRepository.save(post);

        assertEquals("title_test", post.getTitle());
        assertEquals("announcment_test", post.getAnnouncement());
        assertEquals("full_text_test", post.getFull_text());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
    void blogAddTest() throws Exception {
        this.mockMvc
                .perform(get("/blog/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("blog-add"));
    }
    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void blogAddPostTest() throws Exception {

        Post post = new Post();
        post.setTitle("title_test");
        post.setAnnouncement("announcment_test");
        post.setFull_text("full_text_test");
       when(postService.addPost(post)).thenReturn(post);
        this.mockMvc
                .perform(post("/blog/add")
                        .param("title","title_test")
                        .param("announcement","announcment_test")
                        .param("full_text","full_text_test"))
//                .andExpect(status().isOk())
//                .andExpect(postRepository.save(any()))
                .andExpect(view().name("redirect:/blog"));

//        verify(postRepository,times(1)).save(post);
    }

//                .perform(get("/blog/add")
//                        .param("title", "titles")
//                        .param("announcment", "announ")
//                        .param("full_text", "full"))
//                .andExpect(status().isOk())
//                .andExpect(model().attribute("title", is("titles")))
//                .andExpect(model().attribute("announcment", is("announ")))
//                        .andExpect(model().attribute("full_text", is("full")))
//                .andExpect(view().name("redirect:/blog"));
//    }
}
//
//
//        mockMvc.perform(get("/blog"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("blog"));


//    @Test
//    void blogPostAddTest() throws Exception {
//
//
//        Post post = new Post("title", "announcement","full_text");
//        when(service.addPost(post));
//        this.mockMvc.perform(get("/blog/add")).andDo
//                        (blogController.blogPostAdd("title", "announcement","full_text"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(redirectedUrl("http://localhost:8080/blog"));
//

//        assertThat(this.restTemplate.getForObject("http://localhost:8080/blog" ,
//                String.class)).contains("titles");
//        Post post = new Post("title", "announcement","full_text");
//        PostRepository repository = Mockito.mock(PostRepository.class);
//        when(repository.save(post).getTitle());
//        BlogController blogController= new BlogController(repository);
//        blogController.blogPostAdd("title", "announcement","full_text");
//        assertEquals(repository,   );
//        Post post = new Post("title", "announcement","full_text");
//        postRepository.save(post);
//        blogController.blogPostAdd("title", "announcement","full_text");
//
//       assertEquals( );



