package com.tasklets.restbest.repository;

import com.tasklets.restbest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
