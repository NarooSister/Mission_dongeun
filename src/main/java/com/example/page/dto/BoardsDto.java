package com.example.page.dto;

import com.example.page.entity.Article;
import com.example.page.entity.Boards;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class BoardsDto {
    private Long id;
    private String name;
    private List<ArticleDto> articles = new ArrayList<>();
    public BoardsDto(String name){
        this.name = name;
    }

    //static factory method
    public static BoardsDto fromEntity(Boards entity){
        BoardsDto dto = new BoardsDto();
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.articles = new ArrayList<>();
        for(Article article: entity.getArticles())
            dto.articles.add(ArticleDto.fromEntity(article));
        return dto;
    }

}
