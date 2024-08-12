package com.example.blogapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddPostRequest {
    private String author;
    private String content;
    private String title;
}
