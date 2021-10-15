package com.example.project.user.web.service;


import com.example.project.user.domain.dto.user.UserAddRequestDTO;
import com.example.project.user.domain.dto.user.UserAddResponseDTO;
import com.example.project.user.domain.dto.user.UserUpdateRequestDTO;
import com.example.project.user.domain.dto.user.UserUpdateResponseDTO;

public interface UserService {
    public UserAddResponseDTO addUser(UserAddRequestDTO requestDTO);
    public UserUpdateRequestDTO updateUser(UserUpdateResponseDTO requestDTO);
}
