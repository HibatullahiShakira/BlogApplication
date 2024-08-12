package com.example.blogapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class AddCommentRequest {
    private String commentText;
    private String postId;
}
