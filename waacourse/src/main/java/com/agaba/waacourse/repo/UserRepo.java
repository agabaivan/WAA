package com.agaba.waacourse.repo;

import com.agaba.waacourse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo  extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > :count")
    List<User> findUsersWithMoreThanOnePost(int count);

}

