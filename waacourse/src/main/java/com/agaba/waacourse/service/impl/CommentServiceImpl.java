package com.agaba.waacourse.service.impl;

import com.agaba.waacourse.entity.Comment;
import com.agaba.waacourse.repo.CommentRepo;
import com.agaba.waacourse.repo.PostRepo;
import com.agaba.waacourse.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    PostRepo postRepo;

//    public void saveCommentToPost(long postId, Comment comment) {
//        Optional<Post> optionalPost = postRepo.findById(postId);
//        if(optionalPost.isPresent()){
//            Post post2 = optionalPost.get();
//
//            //postRepo.save(comment);
//        }
//        return new ArrayList<>;
//
//    }

    public List<Comment> getCommentsForPost(long postId) {
        return commentRepo.findByPostId(postId);
    }



}
