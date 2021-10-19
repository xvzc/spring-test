package com.example.project.domain.board.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOARDS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @OneToMany(mappedBy = "board")
    private List<Post> posts = new ArrayList<>();

    @Builder
    protected Board(String name) {
        this.name= name;
    }
}