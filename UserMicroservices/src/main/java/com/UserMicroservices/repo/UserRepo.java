package com.UserMicroservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserMicroservices.entities.User;

public interface UserRepo extends JpaRepository<User, String> {

}
