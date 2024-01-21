package com.agaba.waacourse.repo;

import com.agaba.waacourse.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
