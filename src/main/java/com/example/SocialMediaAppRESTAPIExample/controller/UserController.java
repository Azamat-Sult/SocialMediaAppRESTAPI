package com.example.SocialMediaAppRESTAPIExample.controller;

import com.example.SocialMediaAppRESTAPIExample.dao.UserDaoComponent;
import com.example.SocialMediaAppRESTAPIExample.model.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDaoComponent userDaoComponent;
    private final MessageSource messageSource;

    @GetMapping("/users")
    public List<UserDto> findAllUsers() {
        return userDaoComponent.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public EntityModel<UserDto> findUserById(@PathVariable Long id) {
        return userDaoComponent.findUserById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUserDto = userDaoComponent.createUser(userDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUserDto.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userDaoComponent.deleteUserById(id);
    }

    @GetMapping("/hello-internationalized")
    public String helloInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message", null, "Default Message", locale);
    }

}