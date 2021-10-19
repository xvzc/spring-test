package com.example.project.domain.board.dto;

import com.example.project.domain.board.entity.Board;
import com.example.project.domain.board.entity.Post;
import com.example.project.domain.board.entity.QBoard;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

public class BoardDto {

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class AddRequest {
        @NotEmpty
        private String name;

        public Board toEntity() {
            return Board.builder()
                    .name(name)
                    .build();
        }
    }

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class UpdateRequest {
        private String name;
    }

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class Response {
        private Long id;
        private String name;

        public static Response of(final Board board) {
            return Response.builder()
                    .id(board.getId())
                    .name(board.getName())
                    .build();
        }
    }
}