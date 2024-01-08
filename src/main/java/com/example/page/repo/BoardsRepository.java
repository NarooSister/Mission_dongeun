package com.example.page.repo;

import com.example.page.entity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardsRepository extends JpaRepository <Boards, Long> {
}
