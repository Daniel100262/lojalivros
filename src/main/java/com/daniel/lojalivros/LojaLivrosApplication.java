package com.daniel.lojalivros;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daniel.lojalivros.domain.Categoria;
import com.daniel.lojalivros.domain.Livro;
import com.daniel.lojalivros.repositories.CategoriaRepository;
import com.daniel.lojalivros.repositories.LivroRepository;

@SpringBootApplication
public class LojaLivrosApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LojaLivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat = new Categoria(null, "informatica", "Livro de informatica");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum dolor", cat);
		
		cat.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
		
	}
	
	

}
