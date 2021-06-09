package com.daniel.lojalivros.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.lojalivros.domain.Categoria;
import com.daniel.lojalivros.domain.Livro;
import com.daniel.lojalivros.repositories.CategoriaRepository;
import com.daniel.lojalivros.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void InstanciaBD() {
		
		Categoria cat1 = new Categoria(null, "informatica", "Livro de informatica");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Livro de Cientifica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livro de Biografias");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum dolor", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Robert Martin", "Lorem ipsum dolor", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "Louis V. Gerstner", "Lorem ipsum dolor", cat2);
		Livro l4 = new Livro(null, "A Guerra dos Mundos", "H.G. Wells", "Lorem ipsum dolor", cat2);
		Livro l5 = new Livro(null, "Eu, robo", "Isaac Asimov", "Lorem ipsum dolor", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
