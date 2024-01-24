package com.agaba.waacourse.controller;

import com.agaba.waacourse.annotations.ExecutionTime;
import com.agaba.waacourse.entity.Comment;
import com.agaba.waacourse.entity.Post;
import com.agaba.waacourse.entity.User;
import com.agaba.waacourse.entity.response.UserDto;
import com.agaba.waacourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @ExecutionTime
    @GetMapping
    List<User> findAll(){
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") long id){
        return userService.findById(id);
    }
    @GetMapping("/{id}/posts")
    List<Post> findPostbyUserId (@PathVariable("id") long id){
        return userService.findPostbyUserId(id);
    }
    @PostMapping
    void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
    //@GetMapping("/{count}")
    List<User> findUsersWithMoreThanOnePost(@RequestParam("count") int count){
        return userService.findUsersWithMoreThanOnePost(count);
    }
    //@GetMapping("/{title}")
    List<User> findUsersWithPostsOfATitle(@RequestParam("title")String title){
        return userService.findUsersWithPostsOfATitle(title);
    }
    @GetMapping("/{userid}/posts/{postId}/commentList/{commentId}")
    public Comment specificComment (@PathVariable("userid") long userId,@PathVariable("postId") long postId,@PathVariable("commentId") long commentId){
        return userService.specificComment(userId, postId, commentId);
    }

}
