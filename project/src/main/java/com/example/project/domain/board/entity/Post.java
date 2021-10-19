package com.example.project.domain.board.entity;

import com.example.project.domain.board.dto.PostDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "POSTS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false, length = 191)
    private String title;

    @NotEmpty
    @Column(nullable = false, length = 512)
    private String content;

    @ManyToOne
    @JoinColumn(name = "boards_id")
    private Board board;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;

    @Builder
    protected Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

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

    public void update(PostDto.UpdateRequest dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }
}
