package com.agaba.waacourse.service.impl;

import com.agaba.waacourse.repo.CommentRepo;
import com.agaba.waacourse.repo.PostRepo;
import com.agaba.waacourse.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
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
}
