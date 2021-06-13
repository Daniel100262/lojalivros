package com.daniel.lojalivros.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

import com.daniel.lojalivros.domain.Categoria;
import com.daniel.lojalivros.domain.Livro;
import com.daniel.lojalivros.repositories.LivroRepository;
import com.daniel.lojalivros.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired //(spring vai gerenciar instancia automaticamente (cria, atualiza, delete, etc)
	private LivroRepository repository;
	
	@Autowired //(spring vai gerenciar instancia automaticamente (cria, atualiza, delete, etc)
	private CategoriaService catService;
	
	public Livro procuraPeloID(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("O objeto de ID "+id+" , do tipo: "+Livro.class.getName()+" não foi encontrado!"));
	}
	
	public List<Livro> findAll(Integer id_cat){
		catService.procuraPeloID(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro objLivroJSON) {
		Livro livro = procuraPeloID(id);
		atualizaDadosLivro(livro, objLivroJSON);
		
		return repository.save(livro);
	}

	
	private void atualizaDadosLivro(Livro livro, Livro objLivroJSON) {
		livro.setTitulo(objLivroJSON.getTitulo());
		livro.setNomeAutor(objLivroJSON.getNomeAutor());
		livro.setTexto(objLivroJSON.getTexto());
	}

	public Livro criaLivro(Integer id_cat, Livro novoLivroJSON) {
		novoLivroJSON.setId(null);//nulo pq quem gera o ID é o JPA
		Categoria cat = catService.procuraPeloID(id_cat);
		novoLivroJSON.setCategoria(cat);
		return repository.save(novoLivroJSON);
	}

	public void apagaLivro(Integer id) {
		Livro livro = procuraPeloID(id);
		repository.delete(livro);
	}
}
