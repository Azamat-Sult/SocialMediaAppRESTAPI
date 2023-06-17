package com.example.SocialMediaAppRESTAPIExample.service;

import com.example.SocialMediaAppRESTAPIExample.entity.PostEntity;
import com.example.SocialMediaAppRESTAPIExample.entity.UserEntity;
import com.example.SocialMediaAppRESTAPIExample.exception.UserNotFoundException;
import com.example.SocialMediaAppRESTAPIExample.model.CreatePostDto;
import com.example.SocialMediaAppRESTAPIExample.model.PostDto;
import com.example.SocialMediaAppRESTAPIExample.repository.PostRepository;
import com.example.SocialMediaAppRESTAPIExample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostJPAService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    public PostDto saveNewPostToUser(Long id, CreatePostDto createPostDto) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id: " + id));
        PostEntity newPost = new PostEntity();
        newPost.setUser(user);
        newPost.setDescription(createPostDto.getDescription());
        return postRepository.save(newPost).toDto();
    }

}