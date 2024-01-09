package com.example.page.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Boards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String information;
    @OneToMany(mappedBy = "boards")
    private final List<Article> articles = new ArrayList<>();

    public Boards(){}
    public Boards(String name, String information){
        this.name = name;
        this.information = information;
    }
}
