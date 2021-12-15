package com.example.pw25s.service.impl;

import com.example.pw25s.model.Autor;
import com.example.pw25s.model.Livro;
import com.example.pw25s.repository.LivroRepository;
import com.example.pw25s.service.LivroService;
import com.example.pw25s.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroServiceImpl extends CrudServiceImpl<Livro,Long>
implements LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Override
    protected JpaRepository<Livro, Long> getRepository() {
        return livroRepository;
    }

    public Livro findLivrosByAutor(Autor autor){
      return   livroRepository.findLivrosByAutor(autor);
    }
}
