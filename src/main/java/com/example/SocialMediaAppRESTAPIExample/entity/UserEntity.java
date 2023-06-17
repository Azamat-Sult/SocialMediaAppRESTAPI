package com.example.SocialMediaAppRESTAPIExample.entity;

import com.example.SocialMediaAppRESTAPIExample.model.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity(name = "user_details")
public class UserEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private Instant birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<PostEntity> posts;

    public UserDto toDto() {
        return new UserDto(this.id, this.name, this.birthDate, this.posts.stream()
                .map(PostEntity::toDto)
                .collect(Collectors.toList()));
    }

}