package com.example.page.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Article {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String title;
 private String content;
 private String password;

 @ManyToOne
    private Boards boards;

 @OneToMany(mappedBy = "article")
 private final List<Comment> comments = new ArrayList<>();

 public Article(){
 }
    public Article(String title, String content, String password, Boards boards){
        this.title = title;
        this. content = content;
        this.password = password;
        this.boards = boards;
    }
}
