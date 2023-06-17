package com.example.SocialMediaAppRESTAPIExample.model;

import com.example.SocialMediaAppRESTAPIExample.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;
    @JsonProperty("user_name")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @JsonProperty("birth_date")
    @Past(message = "Birth date should be in the past")
    private Instant birthDate;

    private List<PostDto> posts;

    public UserEntity toEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(this.id);
        userEntity.setName(this.name);
        userEntity.setBirthDate(this.getBirthDate());
        userEntity.setPosts(this.posts.stream().map(PostDto::toEntity).collect(Collectors.toList()));
        return userEntity;
    }

}