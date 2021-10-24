package com.example.project.domain.user.service;

import com.example.project.domain.user.dto.UserDto;
import com.example.project.domain.user.entity.User;
import com.example.project.domain.user.repository.UserRepository;

/** Essential imports for Unit tests Start */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
/** Essential imports for Unit tests End */


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @DisplayName("유저 생성")
    @Test
    void addUser() {
    }
}