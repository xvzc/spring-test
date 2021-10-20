package com.example.project.domain.board.repository;

import com.example.project.domain.board.entity.Post;
import com.example.project.domain.board.entity.QPost;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class PostQueryRepository {
    private final JPAQueryFactory queryFactory;

    public PostQueryRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public List<Post> getPosts(Long boardId, String title) {
        QPost post = QPost.post;
        BooleanBuilder builder = new BooleanBuilder();

        if (boardId != null) { // 시도 검색
            builder.and(post.board.id.eq(boardId));
        }

        if (title != null) {
            builder.and(post.title.contains(title));
        }

        return queryFactory.select(post).from(post)
                .where(builder)
                .fetch();
    }
}