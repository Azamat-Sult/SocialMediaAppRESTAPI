package com.example.SocialMediaAppRESTAPIExample.repository;

import com.example.SocialMediaAppRESTAPIExample.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}