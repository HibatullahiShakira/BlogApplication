package com.example.blogapp.services;

import com.example.blogapp.dto.request.AddCommentRequest;
import com.example.blogapp.dto.request.AddPostRequest;
import com.example.blogapp.dto.request.UpdatePostRequest;
import com.example.blogapp.dto.response.AddPostResponse;
import com.example.blogapp.dto.response.UpdatePostResponse;
import com.example.blogapp.models.Post;

import java.util.List;


public interface PostService {
    AddPostResponse addPost(AddPostRequest addPostRequest);
    List<Post> findAll();
    Post findById(String id);
    String addCommentToPost(AddCommentRequest addCommentRequest);
    void deleteById(String id);
    UpdatePostResponse updatePost(UpdatePostRequest updatePostRequest);
}
