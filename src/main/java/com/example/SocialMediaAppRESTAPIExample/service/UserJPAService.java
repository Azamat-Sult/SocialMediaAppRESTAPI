package com.example.SocialMediaAppRESTAPIExample.service;

import com.example.SocialMediaAppRESTAPIExample.controller.UserController;
import com.example.SocialMediaAppRESTAPIExample.entity.UserEntity;
import com.example.SocialMediaAppRESTAPIExample.exception.UserNotFoundException;
import com.example.SocialMediaAppRESTAPIExample.model.PostDto;
import com.example.SocialMediaAppRESTAPIExample.model.UserDto;
import com.example.SocialMediaAppRESTAPIExample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserJPAService {

    private final UserRepository userRepository;
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(UserEntity::toDto)
                .collect(Collectors.toList());
    }

    public EntityModel<UserDto> findUserById(Long id) {
        UserDto foundUserDto = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id: " + id))
                .toDto();
        EntityModel<UserDto> entityModel = EntityModel.of(foundUserDto);
        WebMvcLinkBuilder linkForFindAllUsers =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).findAllUsers());
        entityModel.add(linkForFindAllUsers.withRel("all-users"));
        return entityModel;
    }

    public UserDto createUser(UserDto userDto) {
        return userRepository.save(userDto.toEntity()).toDto();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<PostDto> getUserPostsByUserId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id: " + id))
                .toDto().getPosts();
    }

}