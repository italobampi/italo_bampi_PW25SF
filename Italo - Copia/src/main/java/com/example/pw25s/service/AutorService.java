package com.example.pw25s.service;

import com.example.pw25s.model.Autor;

public interface AutorService extends CrudService<Autor,Long> {

    Autor findByNomeEquals(String autorNome);
}
