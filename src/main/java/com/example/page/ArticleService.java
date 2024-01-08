package com.example.page;

import com.example.page.dto.ArticleDto;
import com.example.page.entity.Article;
import com.example.page.entity.Boards;
import com.example.page.repo.ArticleRepository;
import com.example.page.repo.BoardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private  final BoardsRepository boardsRepository;

    //CREATE
    public ArticleDto create(Long boardsId, ArticleDto dto){
        Boards boards = boardsRepository.findById(boardsId).orElseThrow();
        Article article = new Article(
                dto.getTitle(), dto.getContent(), dto.getPassword(), boards
        );
        return  ArticleDto.fromEntity(articleRepository.save(article));
    }

    //READ
    public ArticleDto read(Long articleId){
        return ArticleDto.fromEntity(articleRepository.findById(articleId).orElseThrow());
    }
    //UPDATE
    public ArticleDto update(Long articleId, ArticleDto dto){
        Article article = articleRepository.findById(articleId).orElseThrow();
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setPassword(dto.getPassword());
        return ArticleDto.fromEntity(articleRepository.save(article));
    }
    //DELETE
    public void delete(Long articleId){
        articleRepository.delete(articleRepository.findById(articleId).orElseThrow());
    }
}
