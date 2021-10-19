package com.example.project.domain.board.controller;

import com.example.project.domain.board.dto.PostDto;
import com.example.project.domain.board.service.PostService;
import com.example.project.global.dto.ListResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public ListResponse<PostDto.Response> getPosts() {
        return ListResponse.of(postService.getPosts());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
