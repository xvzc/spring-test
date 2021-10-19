package com.example.project.domain.board.repository;

import com.example.project.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    public boolean existsByName(String name);
}
