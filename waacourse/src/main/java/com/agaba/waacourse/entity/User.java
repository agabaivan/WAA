package com.agaba.waacourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Post> posts = new ArrayList<>();
    String name;
    int age;

    public User(String name) {
        this.name = name;
    }
    public void addPost(Post post){
        posts.add(post);
    }

}
    
