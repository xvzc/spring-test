package com.example.project.domain.board.service;

import com.example.project.domain.board.dto.BoardDto;
import com.example.project.domain.board.dto.PostDto;
import com.example.project.domain.board.entity.Board;
import com.example.project.domain.board.repository.BoardRepository;
import com.example.project.global.error.ErrorCode;
import com.example.project.global.error.exception.AlreadyExistsException;
import com.example.project.global.error.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<PostDto.Response> getBoardPosts(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.BOARD_NOT_FOUND));

        return board.getPosts().stream().map(PostDto.Response::of).collect(Collectors.toList());
    }

    public BoardDto.Response addBoard(BoardDto.AddRequest dto) {
        if(boardRepository.existsByName(dto.getName())) {
            throw new AlreadyExistsException(ErrorCode.BOARD_DUPLICATION);
        }

        Board board = boardRepository.save(dto.toEntity());

        return BoardDto.Response.of(board);
    }
}
