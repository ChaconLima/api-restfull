package com.chacon.apirestfull.repository;

import com.chacon.apirestfull.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByemail(String email);
}
