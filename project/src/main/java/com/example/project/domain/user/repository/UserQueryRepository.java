package com.example.project.domain.user.repository;

import com.example.project.domain.board.entity.Post;
import com.example.project.domain.board.repository.PostQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserQueryRepository {
    private final JPAQueryFactory query;

    public UserQueryRepository(JPAQueryFactory query) {
        this.query = query;
    }

}
