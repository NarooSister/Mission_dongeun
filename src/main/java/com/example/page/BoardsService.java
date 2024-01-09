package com.example.page;

import com.example.page.dto.BoardsDto;
import com.example.page.entity.Boards;
import com.example.page.repo.BoardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardsService {
    private final BoardsRepository repository;

    //READ
    public List<BoardsDto> readAll() {
        List<BoardsDto> boardsList = new ArrayList<>();
        for (Boards boards : repository.findAll()) {
            boardsList.add(BoardsDto.fromEntity(boards));
        }
        return boardsList;
    }
//    public BoardsDto readOne(Long id){
//        Boards boards = repository.findById(id).orElseThrow();
//        return BoardsDto.fromEntity(boards);
//    }

}
