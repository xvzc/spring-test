package com.example.project.domain.user.service;

import com.example.project._global.error.ErrorCode;
import com.example.project._global.error.exception.AlreadyExistsException;
import com.example.project._global.error.exception.ResourceNotFoundException;
import com.example.project._global.dto.ListResponse;
import com.example.project._global.dto.SingleResponse;
import com.example.project.domain.user.dto.UserDto;
import com.example.project.domain.user.entity.User;
import com.example.project.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public SingleResponse getUser(final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

        return SingleResponse.of(UserDto.Response.of(user));
    }

    public ListResponse getUserList() {
        List<User> users = userRepository.findAll();
        List<UserDto.Response> data = users.stream().map(user -> UserDto.Response.of(user)).collect(Collectors.toList());
        return ListResponse.of(data);
    }

    public SingleResponse addUser(final UserDto.AddRequest dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new AlreadyExistsException(ErrorCode.USER_DUPLICATION);
        }

        User user = userRepository.save(dto.toEntity());

        return SingleResponse.of(UserDto.Response.of(user));
    }

    public SingleResponse updateUser(final UserDto.UpdateRequest dto, final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

//        TODO(Jerry) : findById로 가져온 user와 Session에서 가져온 유저가 동일한지 확인

        User updateUser = user.update(dto);
        return SingleResponse.of(UserDto.Response.of(user));
    }
}