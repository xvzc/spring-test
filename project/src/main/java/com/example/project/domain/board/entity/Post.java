package com.example.project.domain.board.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 191)
    private String title;

    @Column(nullable = false, length = 512)
    private String content;

    @ManyToOne
    @JoinColumn(name = "boards_id", nullable = false)
    private Post post;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;

    @PrePersist
    public void onPrePersist(){
        this.created = LocalDateTime.parse(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
        this.modified = this.created;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.modified= LocalDateTime .parse(
                        LocalDateTime.now() .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                );
    }
}
