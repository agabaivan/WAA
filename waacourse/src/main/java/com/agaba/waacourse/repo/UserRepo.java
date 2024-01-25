package com.agaba.waacourse.repo;

import com.agaba.waacourse.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.function.Predicate;


public interface UserRepo  extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > :count")
    List<User> findUsersWithMoreThanOnePost(int count);
    @Query("SELECT u FROM User u JOIN u.posts p where p.title = : title")
    List<User> findUsersWithPostsOfATitle(String title);



}
