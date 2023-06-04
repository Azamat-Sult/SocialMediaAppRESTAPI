package com.example.SocialMediaAppRESTAPIExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private Instant birthDate;

}