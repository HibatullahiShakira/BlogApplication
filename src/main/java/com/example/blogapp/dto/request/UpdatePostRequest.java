package com.example.blogapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePostRequest {
    private String author;
    private String content;
    private String title;
    private String postId;
}
