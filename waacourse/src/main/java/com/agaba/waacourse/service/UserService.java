package com.agaba.waacourse.service;

import com.agaba.waacourse.entity.Comment;
import com.agaba.waacourse.entity.Post;
import com.agaba.waacourse.entity.User;
import com.agaba.waacourse.entity.response.UserDto;

import java.util.List;

public interface UserService {
    List<User> findAll();
    UserDto findById(long id);

    void saveUser(User user);
    List<Post> findPostbyUserId(long id);
    List<User> findUsersWithMoreThanOnePost(int count);
    List<User> findUsersWithPostsOfATitle(String title);
    public Comment specificComment (long userId, long postId, long commentId);

}
