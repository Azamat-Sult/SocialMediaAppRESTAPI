package com.example.SocialMediaAppRESTAPIExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private Instant timeStamp;
    private String message;
    private String details;

}