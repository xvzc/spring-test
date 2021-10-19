package com.example.project.domain.user.service;

import com.example.project.global.error.ErrorCode;
import com.example.project.global.error.exception.AlreadyExistsException;
import com.example.project.global.error.exception.ResourceNotFoundException;
import com.example.project.domain.user.dto.UserDto;
import com.example.project.domain.user.entity.User;
import com.example.project.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto.Response getUser(final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

        return UserDto.Response.of(user);
    }

    public List<UserDto.Response> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDto.Response::of).collect(Collectors.toList());
    }

    @Transactional
    public UserDto.Response addUser(final UserDto.AddRequest dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new AlreadyExistsException(ErrorCode.USER_DUPLICATION);
        }

        User user = userRepository.save(dto.toEntity());

        return UserDto.Response.of(user);
    }

    @Transactional
    public UserDto.Response updateUser(final UserDto.UpdateRequest dto, final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

//        TODO(Jerry) : findById로 가져온 user와 Session에서 가져온 유저가 동일한지 확인

        user.update(dto);

        return UserDto.Response.of(user);
    }
}