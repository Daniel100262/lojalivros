package com.daniel.lojalivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.lojalivros.domain.Categoria;


//Chave primaria de categoria é um Integer
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}	
