package com.damiannguyen.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
public class BlogPostController {

    @Autowired
    private PostMemoryStorageService postMemoryStorageService;


    @RequestMapping(path="/blog/posts", method = RequestMethod.GET)
    public String getPostList(Model model){
        model.addAttribute("postForm", new PostForm());
        model.addAttribute("posts", postMemoryStorageService.getPosts());
        return "/blog/posts.html";
    }

    @RequestMapping(path="/blog/posts", method = RequestMethod.POST)
    public String createPost(PostForm postForm){
        PostDto postDto = postMemoryStorageService.create(postForm.getTitle(), postForm.getText());
//        return "redirect:/blog/posts/" + postDto.getUuid(); //skok do elementu
        return "redirect:/blog/posts/"; //skok do listy
    }



    @RequestMapping (path = "/blog/posts/{uuid}", method = RequestMethod.GET)
    public String getPost(@PathVariable("uuid") String uuid, Model model) {
        model.addAttribute("post", postMemoryStorageService.getPostDto(uuid).get()); //NPE possible
        return "/blog/post.html";
    }

}
