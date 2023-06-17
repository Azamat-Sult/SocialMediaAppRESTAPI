package com.example.SocialMediaAppRESTAPIExample.entity;

import com.example.SocialMediaAppRESTAPIExample.model.PostDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue()
    private Long id;

    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    public PostDto toDto() {
        return new PostDto(this.id, this.description, this.user.getId());
    }

}