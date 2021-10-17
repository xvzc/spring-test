package com.example.project;

import com.example.project.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {}

}
