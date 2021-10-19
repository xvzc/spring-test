package com.example.project.domain.board.controller;

import com.example.project.domain.board.dto.PostDto;
import com.example.project.domain.board.service.PostService;
import com.example.project.global.dto.ListResponse;
import com.example.project.global.dto.UnitResponse;
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

    @PostMapping("")
    public UnitResponse<PostDto.Response> addPost(@RequestBody PostDto.AddRequest dto) {
        return UnitResponse.of(postService.addPost(dto));
    }

    @PutMapping("/{id}")
    public UnitResponse<PostDto.Response> updatePost(@PathVariable Long id, @RequestBody PostDto.UpdateRequest dto) {
        return UnitResponse.of(postService.updatePost(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
