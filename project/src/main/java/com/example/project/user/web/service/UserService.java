package com.example.project.user.web.service;


import com.example.project.user.domain.dto.UserDto;
import com.example.project.user.domain.dto.user.UserUpdateRequestDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    public UserDto.Res getUser(final Long Id);
    public List<UserDto.Res> getUserList();
    public UserDto.Res addUser(final UserDto.AddReq dto);
    public UserDto.Res updateUser(final UserDto.UpdateReq dto, final Long id);
}
