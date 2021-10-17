package com.example.project.domain.user.entity;

import com.example.project.domain.user.dto.UserDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "USERS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 6, max = 12)
    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Valid
    @Embedded
    private Password password;

    @Column(nullable = false, unique = true, length = 30)
    private String nickname;

    @Column(nullable = false, length = 191)
    private String bio;

    @Valid
    @Embedded
    private Email email;
    /**
     * 만약 컬럼명이 Email 클래스에 정의된 것과 다르다면
     * @AttributeOverride(name="value", column=@Column(name="mail"))로 덮어쓰기 가능
     */

    @CreatedDate
    private LocalDateTime created;

    @Builder
    protected User(String username, String password, String nickname, String bio, String email) {
        this.username = username;
        this.password = Password.of(password);
        this.nickname = nickname;
        this.bio = bio;
        this.email = Email.of(email);
    }

    @PrePersist
    public void onPrePersist(){
        this.created = LocalDateTime.parse(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
    }

    public void update(UserDto.UpdateRequest dto) {
        this.nickname = dto.getNickname();
        this.bio = dto.getBio();
    }
}