package com.example.pw25s.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int ano;
    private String sinopse;
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Autor  autor;
    private Double valor;


}
