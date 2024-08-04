package com.example.blogapp.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter @Setter @ToString @Document
public class Comments {
    @Id
    private String id;
    private String commentText;
    private String postId;
    private LocalDate createdAt = LocalDate.now();
    private LocalDate updatedAt;
}
