package com.example.pw25s.service.impl;

import com.example.pw25s.model.Autor;
import com.example.pw25s.repository.AutorRepository;
import com.example.pw25s.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends CrudServiceImpl<Autor,Long>
implements AutorService {
    @Autowired
    AutorRepository autorRepository;

    public Autor findByNomeEquals(String s){
         return autorRepository.findByNomeEquals(s);
    }
    public Autor findByNomeContaining(String nome){
        return autorRepository.findByNomeContaining(nome);
    }
    @Override
    protected JpaRepository<Autor, Long> getRepository() {
        return autorRepository;
    }

}
