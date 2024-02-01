package com.agaba.waacourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long id;
    String name;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    Post post;

}
