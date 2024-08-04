package com.example.blogapp.services;

import com.example.blogapp.models.Post;
import com.example.blogapp.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class PostServiceImplementation implements PostService{

    private PostRepository postRepository;


    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return List.of();
    }

    @Override
    public Post findById(String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
