package com.example.project.user.web.service;


import com.example.project.user.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto.Response getUser(final Long Id);
    public List<UserDto.Response> getUserList();
    public UserDto.Response addUser(final UserDto.AddRequest dto);
    public UserDto.Response updateUser(final UserDto.UpdateRequest dto, final Long id);
}
