package com.agaba.waacourse.service;

import com.agaba.waacourse.entity.Comment;
import com.agaba.waacourse.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll();

    Post findPostsById(long id);

    void savePost(Post post);
    List<Post> findPostsByTitle(String title);

    void saveComment(long id, Comment comment);

    void deletePostById(long id);

    void updatePost(long id, Post updatedPost);

}
