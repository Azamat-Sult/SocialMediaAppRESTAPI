package com.example.SocialMediaAppRESTAPIExample.controller;

import com.example.SocialMediaAppRESTAPIExample.model.UserDto;
import com.example.SocialMediaAppRESTAPIExample.service.UserJPAService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserJPAController {

    private final UserJPAService userJPAService;

    @GetMapping("/jpa/users")
    public List<UserDto> findAllUsers() {
        return userJPAService.findAllUsers();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<UserDto> findUserById(@PathVariable Long id) {
        return userJPAService.findUserById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUserDto = userJPAService.createUser(userDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUserDto.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userJPAService.deleteUserById(id);
    }

}