package com.example.SocialMediaAppRESTAPIExample.model;

import com.example.SocialMediaAppRESTAPIExample.entity.PostEntity;
import com.example.SocialMediaAppRESTAPIExample.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {

    private Long id;

    private String description;

    private long userId;

    public PostEntity toEntity() {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(this.id);
        postEntity.setDescription(this.description);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(this.userId);
        postEntity.setUser(userEntity);
        return postEntity;
    }

}