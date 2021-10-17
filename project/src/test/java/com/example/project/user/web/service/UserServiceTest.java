package com.example.project.user.web.service;

import com.example.project.user.domain.dto.UserDto;
import com.example.project.user.domain.entity.User;
import com.example.project.user.domain.repository.UserRepository;

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
import static org.hamcrest.CoreMatchers.equalTo;
/** Essential imports for Unit tests End */


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @DisplayName("유저 생성")
    @Test
    void addUser() {
        final UserDto.AddRequest dto = UserDto.AddRequest.builder()
                .username("username")
                .password("PaSsWoRd!2!#")
                .nickname("usernick")
                .bio("hello world")
                .email("user@email.com")
                .build();

        User user= dto.toEntity();
        doReturn(user).when(userRepository).save(any(User.class));

        UserDto.Response ret = new UserDto.Response(user);
        assertThat(userService.addUser(dto), is(equalTo(ret)));
    }
}
