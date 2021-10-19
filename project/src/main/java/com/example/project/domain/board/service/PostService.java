package com.example.project.domain.board.service;

import com.example.project.domain.board.dto.PostDto;
import com.example.project.domain.board.entity.Post;
import com.example.project.domain.board.repository.PostQueryRepository;
import com.example.project.domain.board.repository.PostRepository;
import com.example.project.domain.user.dto.UserDto;
import com.example.project.global.error.ErrorCode;
import com.example.project.global.error.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostQueryRepository postQueryRepository;

    public PostService(PostRepository postRepository, PostQueryRepository postQueryRepository) {
        this.postRepository = postRepository;
        this.postQueryRepository = postQueryRepository;
    }

    public PostDto.Response getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.POST_NOT_FOUND));

        return PostDto.Response.of(post);
    }

    public List<PostDto.Response> getPosts(Long boardId, String title) {
        List<Post> posts = postQueryRepository.getPosts(boardId, title);
        return posts.stream().map(PostDto.Response::of).collect(Collectors.toList());
    }

    public PostDto.Response addPost(PostDto.AddRequest dto) {
        Post post = postRepository.save(dto.toEntity());
        return PostDto.Response.of(post);
    };

    @Transactional
    public PostDto.Response updatePost(Long id, PostDto.UpdateRequest dto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.POST_NOT_FOUND));

        post.update(dto);
        return PostDto.Response.of(post);
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.POST_NOT_FOUND));

        postRepository.delete(post);
        return;
    }
}
