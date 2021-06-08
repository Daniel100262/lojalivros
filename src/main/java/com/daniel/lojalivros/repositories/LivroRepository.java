package com.daniel.lojalivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.daniel.lojalivros.domain.Livro;


//Chave primaria de Livro é um Integer
@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
	
}	
