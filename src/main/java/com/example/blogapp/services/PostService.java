package com.example.blogapp.services;

import com.example.blogapp.models.Post;

import java.util.List;


public interface PostService {
    Post save(Post post);
    List<Post> findAll();
    Post findById(String id);
    void deleteById(String id);
}
