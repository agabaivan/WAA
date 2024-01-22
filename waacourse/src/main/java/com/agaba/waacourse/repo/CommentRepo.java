package com.agaba.waacourse.repo;

import com.agaba.waacourse.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
