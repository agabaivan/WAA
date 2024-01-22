package com.agaba.waacourse.service.impl;

import com.agaba.waacourse.entity.Comment;
import com.agaba.waacourse.entity.Post;
import com.agaba.waacourse.entity.User;
import com.agaba.waacourse.entity.response.UserDto;
import com.agaba.waacourse.repo.CommentRepo;
import com.agaba.waacourse.repo.PostRepo;
import com.agaba.waacourse.repo.UserRepo;
import com.agaba.waacourse.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    PostRepo postRepo;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    public List<Post> findPostbyUserId(long id){
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get().getPosts();
        }
        return new ArrayList<>();
    }

    @Override
    public List<User> findUsersWithMoreThanOnePost(int count) {
        return userRepo.findUsersWithMoreThanOnePost(count);
    }

    @Override
    public List<User> findUsersWithPostsOfATitle(String title) {
        return userRepo.findUsersWithPostsOfATitle(title);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
    public Comment specificComment (long userId, long postId, long commentId){
        Optional <User> userOptional = userRepo.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Optional <Post> postOptional = postRepo.findById(postId);
            if(postOptional.isPresent() && user.getPosts().contains(postOptional.get()) ){
                Optional <Comment> commentOptional = commentRepo.findById(commentId);
                Post post = postOptional.get();
                if(commentOptional.isPresent() && post.getCommentList().contains(commentOptional.get())){
                    return commentOptional.get();
                }
            }
        }
        return null;
    }

}
