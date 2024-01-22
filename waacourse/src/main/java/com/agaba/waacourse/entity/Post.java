package com.agaba.waacourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;
        String title;
        String content;
        String author;
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn
        List<Comment> commentList = new ArrayList<>();

        public void addComment(Comment comment){
                commentList.add(comment);
        }


        public Post(String title, String content, String author) {
                this.title = title;
                this.content = content;
                this.author = author;
        }
}
