package com.example.page.dto;

import com.example.page.entity.Article;
import com.example.page.entity.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private String password;
    private List<CommentDto> comments = new ArrayList<>();
    public ArticleDto(String title, String content, String password){
        this.title = title;
        this.content = content;
        this.password = password;
    }
    //static factory method
    public static ArticleDto fromEntity(Article entity){
        ArticleDto dto = new ArticleDto();
        dto.id = entity.getId();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        dto.password = entity.getPassword();
        for(Comment comment: entity.getComments())
            dto.comments.add(CommentDto.fromEntity(comment));
        return dto;
    }
}
