package com.example.SocialMediaAppRESTAPIExample.dao;

import com.example.SocialMediaAppRESTAPIExample.controller.UserController;
import com.example.SocialMediaAppRESTAPIExample.exception.UserNotFoundException;
import com.example.SocialMediaAppRESTAPIExample.model.UserDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoComponent {

    private static List<UserDto> userDtos = new ArrayList<>();
    private static Long usersCount = 0L;

    static {
        userDtos.add(new UserDto(++usersCount, "User 1", Instant.now().minus(30, ChronoUnit.DAYS)));
        userDtos.add(new UserDto(++usersCount, "User 2", Instant.now().minus(25, ChronoUnit.DAYS)));
        userDtos.add(new UserDto(++usersCount, "User 3", Instant.now().minus(20, ChronoUnit.DAYS)));
    }

    public List<UserDto> findAllUsers() {
        return userDtos;
    }

    public EntityModel<UserDto> findUserById(Long id) {
        UserDto foundUserDto = userDtos.stream().filter(userDto -> id.equals(userDto.getId()))
                .findFirst()
                .orElse(null);
        if (foundUserDto == null) throw new UserNotFoundException("id: " + id);

        EntityModel<UserDto> entityModel = EntityModel.of(foundUserDto);
        WebMvcLinkBuilder linkForFindAllUsers =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).findAllUsers());
        entityModel.add(linkForFindAllUsers.withRel("all-users"));
        return entityModel;
    }

    public UserDto createUser(UserDto userDto) {
        userDto.setId(++usersCount);
        userDtos.add(userDto);
        return userDto;
    }

    public void deleteUserById(Long id) {
        UserDto foundUserDto = userDtos.stream().filter(userDto -> id.equals(userDto.getId()))
                .findFirst()
                .orElse(null);
        if (foundUserDto == null) throw new UserNotFoundException("id: " + id);
        userDtos.remove(foundUserDto);
    }

}