package com.example.blogapp.repositories;

import com.example.blogapp.models.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comments, String> {
}
