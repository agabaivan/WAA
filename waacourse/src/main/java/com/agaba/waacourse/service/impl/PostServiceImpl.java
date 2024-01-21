package com.agaba.waacourse.service.impl;

import com.agaba.waacourse.entity.Post;
import com.agaba.waacourse.entity.response.Postdto;
import com.agaba.waacourse.repo.PostRepo;
import com.agaba.waacourse.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Postdto findById(long id) {
        return modelMapper.map(postRepo.findById(id), Postdto.class);
    }

    @Override
    public void savePost(Post post) {
    postRepo.save(post);
    }

    @Override
    public List<Post> findPostsByTitle(String title) {
        return postRepo.findPostsByTitle(title);
    }

}
