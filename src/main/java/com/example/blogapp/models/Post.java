package com.example.blogapp.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
@Getter @Setter @ToString @Document
public class Post {
    @Id
    private String id;
    private String author;
    private String content;
    private String title;
    private LocalDate createdAt = LocalDate.now();
    private LocalDate updatedAt;
    private List<Comments> comments;
}
