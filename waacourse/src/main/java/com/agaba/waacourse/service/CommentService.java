package com.agaba.waacourse.service;

import com.agaba.waacourse.entity.Comment;

import java.util.List;

public interface CommentService  {
      List<Comment> getCommentsForPost(long postId);

}
