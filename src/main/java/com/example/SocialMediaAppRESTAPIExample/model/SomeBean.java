package com.example.SocialMediaAppRESTAPIExample.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties("field1")
@JsonFilter("someBeanFilter")
public class SomeBean {

    private String field1;
    //@JsonIgnore
    private String field2;
    private String field3;

}