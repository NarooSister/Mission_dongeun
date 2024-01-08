package com.example.page.dto;

import com.example.page.entity.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String content;
    private String password;
    public CommentDto(String content, String password){
        this.content = content;
        this.password = password;
    }
    ////static factory method
    public static CommentDto fromEntity(Comment entity) {
        CommentDto dto = new CommentDto();
        dto.id = entity.getId();
        dto.content = entity.getContent();
        dto.password = entity.getPassword();
        return dto;
    }

}
