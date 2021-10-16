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

    public UserDto.Res getUser(final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

        return new UserDto.Res(user);
    }

    public List<UserDto.Res> getUserList() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserDto.Res(user)).collect(Collectors.toList());
    }

    public UserDto.Res addUser(final UserDto.AddReq dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new AlreadyExistsException(ErrorCode.USER_DUPLICATION);
        }

        User user = userRepository.save(dto.toEntity());

        return new UserDto.Res(user);
    }

    @Override
    public UserDto.Res updateUser(final UserDto.UpdateReq dto, final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

//        TODO(Jerry) : findById로 가져온 user와 Session에서 가져온 유저가 동일한지 확인

        User updateUser = user.builder()
                .bio(dto.getBio())
                .nickname(dto.getNickname())
                .build();

        return new UserDto.Res(updateUser);
    }
}