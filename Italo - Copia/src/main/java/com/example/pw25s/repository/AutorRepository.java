package com.example.pw25s.repository;

import com.example.pw25s.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    public Autor findByNomeEquals(String nome);
    public Autor findByNomeContaining(String nome);
}
