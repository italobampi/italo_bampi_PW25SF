package com.example.pw25s.model.dto;

import com.example.pw25s.model.Livro;
import com.example.pw25s.service.AutorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;

@Data
public class LivroSalvarDTO {

    @NotBlank
    private String titulo;

    @NotBlank
    private String sinopse;

    @NotBlank
    private String ano;

    @NotBlank
    private String valor;

    @NotBlank
    private String autorNome;


@Autowired
    AutorService autorService;

    public Livro toLivro() {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAno(Integer.parseInt(ano));
        livro.setValor(Double.parseDouble(valor));
        System.out.println("\n\n\n\n\n\n\n\n\n\n-"+autorNome+"-\n\n\n\n\n\n\n\n\n\n");
        livro.setAutor(autorService.findByNomeEquals(autorNome));
        livro.setSinopse(sinopse);
        System.out.println("\n\n\n\n\n\n\n\n\n\n"+livro+"\n\n\n\n\n\n\n\n\n\n");
        return livro;
    }
}
