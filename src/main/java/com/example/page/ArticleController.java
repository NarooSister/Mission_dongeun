package com.example.page;

import com.example.page.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("boards/{boardsId}/article")
@RequiredArgsConstructor
public class ArticleController {
    private final BoardsService boardsService;
    private final ArticleService articleService;

    @PostMapping
    public String create(
            @PathVariable("boardsId")
            Long boardsId,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("password")
            String password
    ){
        articleService.create(boardsId, new ArticleDto(title, content, password));
        return String.format("redirect:/boards/%d", boardsId);
    }
    @GetMapping("{articleId}/update")
    public String update(
            @PathVariable("boardsId")
            Long boardsId,
            @PathVariable("articleId")
            Long articleId,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("password")
            String password
    ){
        articleService.update(articleId, new ArticleDto(title, content, password));
        return String.format("redirect:/boards/%d", boardsId);
    }
}
