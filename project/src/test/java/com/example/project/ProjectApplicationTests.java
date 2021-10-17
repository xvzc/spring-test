package com.example.project;

import com.example.project.domain.user.entity.Email;
import com.example.project.domain.user.entity.User;
import com.example.project.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        User user = userRepository.save(
                User.builder()
                .username("user13s23")
                .password("awefsdfe123123")
                .nickname("nick21aw3")
                .bio("awefawef")
                .email(Email.of("eawweef@email.com"))
                .build()
        );

        System.out.println(user.getCreated());
        System.out.println(user.getCreated());
        System.out.println(user.getCreated());
        System.out.println(user.getCreated());
        System.out.println(user.getCreated());
        System.out.println(user.getCreated());

        User updateUser = user.builder()
                .nickname("nickname02")
                .build();
    }

}
