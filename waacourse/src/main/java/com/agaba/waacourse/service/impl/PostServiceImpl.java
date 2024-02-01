package com.agaba.waacourse.service.impl;

import com.agaba.waacourse.entity.Comment;
import com.agaba.waacourse.entity.Post;
import com.agaba.waacourse.exceptions.NotFoundException;
import com.agaba.waacourse.repo.PostRepo;
import com.agaba.waacourse.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
    public Post findPostsById(long id){
        return postRepo.findPostsById(id);
    }

    @Override
    public void savePost(Post post) {
    postRepo.save(post);
    }

    @Override
    public void deletePostById(long id) {
        try {

            if (postRepo.existsById(id)) {

                postRepo.deleteById(id);
            } else {

                throw new NotFoundException("Post not found with id: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details
            throw new RuntimeException("Error deleting post with id: " + id, e);
        }
    }

    @Override
    public void updatePost(long id, Post updatedPost) {
        Post existingPost = postRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Post not found with id: " + id));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setAuthor(updatedPost.getAuthor());
        existingPost.setCommentList(updatedPost.getCommentList());
        postRepo.save(existingPost);

    }

    @Override
    public List<Post> findPostsByTitle(String title) {
        return postRepo.findPostsByTitle(title);
    }

    @Override
    public void saveComment(long id, Comment comment) {
        Optional <Post> optionalPost = postRepo.findById(id);
        optionalPost.ifPresent(post -> post.addComment(comment));
    }

}
