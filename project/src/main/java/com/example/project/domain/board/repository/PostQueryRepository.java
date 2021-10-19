package com.example.project.domain.board.repository;

import com.example.project.domain.board.entity.Post;
import com.example.project.domain.board.entity.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostQueryRepository {
    private final JPAQueryFactory query;

    public PostQueryRepository(JPAQueryFactory query) {
        this.query = query;
    }

    public List<Post> getPosts(Long boardId, String title) {
        QPost post = QPost.post;
        return query.select(post).from(post)
                .where(post.title.contains(title).and(post.board.id.eq(boardId)))
                .fetch();
    }
}