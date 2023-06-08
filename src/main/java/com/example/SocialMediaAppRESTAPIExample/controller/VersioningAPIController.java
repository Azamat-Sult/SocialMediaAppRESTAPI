package com.example.SocialMediaAppRESTAPIExample.controller;

import com.example.SocialMediaAppRESTAPIExample.model.PersonV1;
import com.example.SocialMediaAppRESTAPIExample.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningAPIController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("John Wick");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2("John", "Wick");
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("John Wick");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2("John", "Wick");
    }

    @GetMapping(value = "/person", headers = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("John Wick");
    }

    @GetMapping(value = "/person", headers = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        return new PersonV2("John", "Wick");
    }

}