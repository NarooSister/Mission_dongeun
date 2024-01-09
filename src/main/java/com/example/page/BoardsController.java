package com.example.page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardsController {
    private final BoardsService boardsService;
    @GetMapping
    public String boards(Model model){
        model.addAttribute("boards", boardsService.readAll());
        return "boards/home";
    }
//    @GetMapping("{id}")
//    public String boardsOne(
//            @PathVariable("id")
//            Long id,
//            Model model)
//    {
//        model.addAttribute("boards", boardsService.readOne(id));
//        return "boards/read";
//    }

}

