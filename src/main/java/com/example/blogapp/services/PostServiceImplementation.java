package com.example.blogapp.services;

import com.example.blogapp.dto.request.AddCommentRequest;
import com.example.blogapp.dto.request.AddPostRequest;
import com.example.blogapp.dto.request.UpdatePostRequest;
import com.example.blogapp.dto.response.AddPostResponse;
import com.example.blogapp.dto.response.UpdatePostResponse;
import com.example.blogapp.models.Comments;
import com.example.blogapp.models.Post;
import com.example.blogapp.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class PostServiceImplementation implements PostService{

    private PostRepository postRepository;

    @Override
    public AddPostResponse addPost(AddPostRequest addPostRequest) {
        String title = addPostRequest.getTitle();
        String content = addPostRequest.getContent();
        String author = addPostRequest.getAuthor();

        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setAuthor(author);
        Post savedPost = postRepository.save(newPost);

        AddPostResponse addPostResponse = new AddPostResponse();
        addPostResponse.setPostId(savedPost.getId());
        addPostResponse.setMessage("Post added successfully");
        return addPostResponse;
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
    public String addCommentToPost(AddCommentRequest addCommentRequest) {
        Optional<Post> foundPost = postRepository.findById(addCommentRequest.getPostId());

        String comment = addCommentRequest.getCommentText();
        Comments comments = new Comments();
        LocalDate updatedAt=  LocalDate.now();
        comments.setCommentText(comment);
        comments.setUpdatedAt(updatedAt);

        if (foundPost.isPresent()) {
            Post post = foundPost.get();
            List<Comments> postComments = post.getComments();
            postComments.add(comments);
            post.setComments(postComments);
            postRepository.save(post);
        }
        return "Comment added successfully";
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public UpdatePostResponse updatePost(UpdatePostRequest updatePostRequest) {
            Post foundPost = postRepository.findById(updatePostRequest.getPostId()).orElse(null);
            if (foundPost == null){
                throw new NullPointerException("Post not found");
            }else {
                if (updatePostRequest.getContent() != null) foundPost.setContent(updatePostRequest.getContent());
                if (updatePostRequest.getAuthor() != null) foundPost.setAuthor(updatePostRequest.getAuthor());
                if (updatePostRequest.getTitle() != null) foundPost.setTitle(updatePostRequest.getTitle());
                postRepository.save(foundPost);
            }
            return new UpdatePostResponse("Post Update Successful");
    }
}
