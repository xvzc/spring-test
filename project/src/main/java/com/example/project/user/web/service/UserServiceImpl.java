package com.example.project.user.web.service;

import com.example.project._global.exception.user.UserAlreadyExistsException;
import com.example.project.user.domain.dto.user.UserAddRequestDTO;
import com.example.project.user.domain.dto.user.UserAddResponseDTO;
import com.example.project.user.domain.dto.user.UserUpdateRequestDTO;
import com.example.project.user.domain.dto.user.UserUpdateResponseDTO;
import com.example.project.user.domain.entity.User;
import com.example.project.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    // 생성자 주입을 권장합니다.
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserAddResponseDTO addUser(UserAddRequestDTO requestDTO) {
        if (userRepository.existsById(1L)) {
            throw new UserAlreadyExistsException();
        }

        // Setter 사용을 지양하여 불변 상태를 유지합니다.
        // 생성자를 사용하는 방법도 있지만 가독성이 떨어지기 때문에 Builder 패턴을 사용합니다.
        User user = userRepository.save(
                User.builder()
                        .username(requestDTO.getUsername())
                        .password(requestDTO.getPassword())
                        .bio(requestDTO.getBio())
                        .email(requestDTO.getEmail())
                        .build()
        );

        return UserAddResponseDTO.builder()
                .username(user.getUsername())
                .nickname(user.getNickname())
                .bio(user.getBio())
                .email(user.getEmail())
                .build();
    }

    @Override
    public UserUpdateRequestDTO updateUser(UserUpdateResponseDTO requestDTO) {
        return null;
    }
}