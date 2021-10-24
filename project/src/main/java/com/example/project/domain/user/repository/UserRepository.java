package com.example.project.domain.user.repository;

import com.example.project.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
//    boolean existsByUsername(String username);
    Optional<User> findByEmail(String email); // 이미 email을 통해 생성된 사용자인지 체크

}
