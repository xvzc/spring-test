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
}