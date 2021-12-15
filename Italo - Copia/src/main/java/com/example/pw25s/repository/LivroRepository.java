package com.example.pw25s.repository;

import com.example.pw25s.model.Autor;
import com.example.pw25s.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    public Livro findLivrosByAutor(Autor autor);

}
