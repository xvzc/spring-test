package com.example.project.user.web.service;

import com.example.project._global.error.ErrorCode;
import com.example.project._global.error.exception.AlreadyExistsException;
import com.example.project._global.error.exception.ResourceNotFoundException;
import com.example.project.user.domain.dto.UserDto;
import com.example.project.user.domain.entity.User;
import com.example.project.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserDto.Response getUser(final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

        return new UserDto.Response(user);
    }

    public List<UserDto.Response> getUserList() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserDto.Response(user)).collect(Collectors.toList());
    }

    public UserDto.Response addUser(final UserDto.AddRequest dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new AlreadyExistsException(ErrorCode.USER_DUPLICATION);
        }

        User user = userRepository.save(dto.toEntity());

        return new UserDto.Response(user);
    }

    @Override
    public UserDto.Response updateUser(final UserDto.UpdateRequest dto, final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

//        TODO(Jerry) : findById로 가져온 user와 Session에서 가져온 유저가 동일한지 확인

        User updateUser = user.builder()
                .bio(dto.getBio())
                .nickname(dto.getNickname())
                .build();

        return new UserDto.Response(updateUser);
    }
}