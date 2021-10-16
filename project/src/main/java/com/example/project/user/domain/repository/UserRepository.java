package com.example.project.user.domain.repository;

import com.example.project.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
    boolean existsByUsername(String username);
}
