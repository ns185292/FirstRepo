package com.example.backend.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
}