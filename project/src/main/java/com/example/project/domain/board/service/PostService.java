package com.example.project.domain.board.service;

import com.example.project.domain.board.dto.PostDto;
import com.example.project.domain.board.entity.Post;
import com.example.project.domain.board.repository.PostRepository;
import com.example.project.domain.user.dto.UserDto;
import com.example.project.global.error.ErrorCode;
import com.example.project.global.error.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PostService {
    PostRepository postRepository;

    public PostDto.Response addPost(PostDto.AddRequest dto) {
        Post post = postRepository.save(dto.toEntity());
        return PostDto.Response.of(post);
    };

    @Transactional
    public PostDto.Response updatePost(PostDto.UpdateRequest dto, Long id) {
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
