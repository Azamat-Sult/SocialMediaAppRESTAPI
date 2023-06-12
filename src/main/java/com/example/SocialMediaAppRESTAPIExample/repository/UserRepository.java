package com.example.SocialMediaAppRESTAPIExample.repository;

import com.example.SocialMediaAppRESTAPIExample.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}