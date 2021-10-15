package com.example.project.user.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "USERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false, length = 512)
    private String password;

    @Column(nullable = false, unique = true, length = 30)
    private String nickname;

    @Column(nullable = false, length = 191)
    private String bio;

    @Column(nullable = false, length = 512)
    private String email;

    @CreatedDate
    private String created;

    @Builder
    protected User(String username, String password, String nickname, String bio, String email) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.bio = bio;
        this.email = email;
    }

    @PrePersist
    public void onPrePersist(){
        this.created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
