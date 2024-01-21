package com.agaba.waacourse.service;

import com.agaba.waacourse.entity.Post;
import com.agaba.waacourse.entity.response.Postdto;

import java.util.List;

public interface PostService {

    List<Post> findAll();
    Postdto findById(long id);

    void savePost(Post post);
    List<Post> findPostsByTitle(String title);
}
