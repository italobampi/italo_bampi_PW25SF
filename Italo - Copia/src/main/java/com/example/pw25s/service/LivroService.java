package com.example.pw25s.service;

import com.example.pw25s.model.Autor;
import com.example.pw25s.model.Livro;

public interface LivroService extends CrudService<Livro,Long> {
    Livro findLivrosByAutor(Autor autor);
}
