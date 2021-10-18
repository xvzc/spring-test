package com.example.project.domain.board.dto;


import com.example.project.domain.board.entity.Post;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

public class PostDto {

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class AddRequest {
        @NotEmpty
        private String title;
        @NotEmpty
        private String content;

        public Post toEntity() {
            return Post.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class UpdateRequest {
        private String title;
        private String content;
    }

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class Response {
        private Long id;
        private String title;
        private String content;

        public static Response of(final Post post) {
            return Response.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .build();
        }
    }
}