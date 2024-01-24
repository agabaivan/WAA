package com.agaba.waacourse.controller;

import com.agaba.waacourse.entity.Comment;
import com.agaba.waacourse.entity.Post;
import com.agaba.waacourse.entity.response.Postdto;
import com.agaba.waacourse.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
     public Postdto findById(@PathVariable("id") long id){
        return postService.findById(id);
    }

    @PostMapping("/")
    public void savePost(@RequestBody Post post) {
        postService.savePost(post);
    }
    @GetMapping("/{title}")
    public List<Post> findPostsByTitle(@PathVariable("title") String title){
        return postService.findPostsByTitle(title);
    }
    @PostMapping("/{id}/comments")
    public void saveComment(@RequestBody Comment comment, @PathVariable("id") long id) {
        postService.saveComment(id, comment);
    }


}
