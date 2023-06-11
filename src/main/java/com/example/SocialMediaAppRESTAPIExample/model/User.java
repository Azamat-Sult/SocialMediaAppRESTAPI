package com.example.SocialMediaAppRESTAPIExample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    @JsonProperty("user_name")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @JsonProperty("birth_date")
    @Past(message = "Birth date should be in the past")
    private Instant birthDate;

}