package com.example.SocialMediaAppRESTAPIExample.entity;

import com.example.SocialMediaAppRESTAPIExample.model.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;

@Data
@Entity(name = "user_details")
public class UserEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private Instant birthDate;

    public UserDto toDto() {
        return new UserDto(this.id, this.name, this.birthDate);
    }

}