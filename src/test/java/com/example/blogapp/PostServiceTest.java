package com.example.blogapp;

import com.example.blogapp.dto.request.AddPostRequest;
import com.example.blogapp.dto.request.UpdatePostRequest;
import com.example.blogapp.dto.response.AddPostResponse;
import com.example.blogapp.dto.response.UpdatePostResponse;
import com.example.blogapp.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @Test
    void testSavePost(){
        String title = "#EndBadGovernance Protests";
        String content = "Kasala Aff Burst in Yaba o";
        String author = "Shakirah";

        AddPostRequest addPostRequest = new AddPostRequest();
        addPostRequest.setTitle(title);
        addPostRequest.setContent(content);
        addPostRequest.setAuthor(author);

        AddPostResponse response = postService.addPost(addPostRequest);

        assertNotNull(response);
        assertNotNull(response.getPostId());
        assertEquals(response.getMessage(), "Post added successfully");
    }

    @Test
    void testUpdatePost(){
        String title = "#EndBadGovernance Protests";
        String content = "Kasala Aff Burst in Yaba o";
        String author = "Shakirah";

        AddPostRequest addPostRequest = new AddPostRequest();
        addPostRequest.setTitle(title);
        addPostRequest.setContent(content);
        addPostRequest.setAuthor(author);
        AddPostResponse response = postService.addPost(addPostRequest);
        assertNotNull(response);

        UpdatePostRequest updatePostRequest = new UpdatePostRequest();
        updatePostRequest.setPostId(response.getPostId());
        updatePostRequest.setContent("Kasala no burst again, All settled!");

        UpdatePostResponse updatePostResponse = postService.updatePost(updatePostRequest);
        assertEquals(updatePostResponse.getMessage(), "Post Update Successful");
        assertNotNull(updatePostResponse.getMessage());
    }

    void testWhenPostISaved_addComment(){
        String title = "#EndBadGovernance Protests";
        String content = "Kasala Aff Burst in Yaba o";
        String author = "Shakirah";

    }
}
