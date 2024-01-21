package com.agaba.waacourse.repo;

import com.agaba.waacourse.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepo extends JpaRepository<Post, Long> {
    //@Query("SELECT p FROM Post p WHERE p.title =: title ")
    List<Post> findPostsByTitle(String title);

}
