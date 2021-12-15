package com.example.pw25s.model.dto;

import com.example.pw25s.model.Autor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AutorSalvarDTO {

    @NotBlank
    private String nome;

    public Autor toAutor(){
        Autor autor = new Autor();
        autor.setNome(nome);

        return autor;
    }
}
