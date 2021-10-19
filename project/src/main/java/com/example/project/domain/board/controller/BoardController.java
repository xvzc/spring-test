package com.example.project.domain.board.controller;

import com.example.project.domain.board.dto.PostDto;
import com.example.project.domain.board.service.BoardService;
import com.example.project.global.dto.ListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("{id}")
    public ListResponse<PostDto.Response> getBoardPosts(@PathVariable Long id) {
        return ListResponse.of(boardService.getBoardPosts(id));
    }

}
