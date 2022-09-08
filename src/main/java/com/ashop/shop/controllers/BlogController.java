package com.ashop.shop.controllers;

import com.ashop.shop.models.Post;
import com.ashop.shop.repositories.PostRepository;
import com.ashop.shop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    /**
     * Handles the HTTP GET mapping request the list of created blog posts
     *
     * @return a redirection to the blog page where all blogs are shown
     */
    @GetMapping("/blog")
    public String blog(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }


    /**
     * POST http request that saves Post object
     * .addPost method  delegate to separate services in class PostService instead using  postRepository.save(post)
     * add the action instead of URL to method post
     *
     * @param title        tile  object retrieved from the view template
     * @param announcement announcement   object retrieved from the view template
     * @param full_text    full_text object
     * @return a redirection to the http request for the list of all blog posts
     */
    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String announcement, @RequestParam String full_text) {
        Post post = new Post(title, announcement, full_text);
//  instead   postRepository.save(post); delegate to separate services
        postService.addPost(post);

        return "redirect:/blog";
    }

    /**
     * Handles the HTTP GET mapping request that show specific blog post by its own id.
     *@param model encapsulates the  data that  present the blog model with  its parameter
     * @return page with individual details of the post.
     */

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }

        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

    /**
     * Handles the HTTP GET mapping request that allow to edit a single blog post
     * if post indicated by
     *
     * @param id of the blog post,  if is not exist in database it will
     * @return redirect to all posts
     * Use Optional to store the retrieved post from database through postRepository
     * @param model encapsulates the  data that  present the blog model with  its parameter
     * @return redirect to edit sample page
     */

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }

        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-edit";
    }

    /**
     * POST http request that  edit and saves the change of Post object
     * it set the new parameter to the retrieved object by id
     *
     * @param id           of post  object retrieved from the view template
     * @param title        tile  object retrieved from the view template
     * @param announcement announcement   object retrieved from the view template
     * @param full_text    full_text object
     * @return a redirection to the http request for the list of all blog posts
     */

    @PostMapping("/blog/{id}/edit")

    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String announcement, @RequestParam String full_text) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnnouncement(announcement);
        post.setFull_text(full_text);
        postRepository.save(post);

        return "redirect:/blog";
    }

    /**
     * POST http request that  delete the Post object  retrieved by id
     * from website and database
     *
     * @param id    of post  object retrieved from the view template
     * @param model encapsulates the  data that  present the blog model with  its parameter
     * @return a redirection to the http request for the list of all blog posts
     */

    @PostMapping("/blog/{id}/remove")

    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);

        return "redirect:/blog";
    }
}
