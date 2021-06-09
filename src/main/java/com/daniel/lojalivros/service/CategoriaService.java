package com.daniel.lojalivros.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.daniel.lojalivros.domain.Categoria;
import com.daniel.lojalivros.repositories.CategoriaRepository;
import com.daniel.lojalivros.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria procuraPeloID(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("O objeto de ID "+id+" , do tipo: "+Categoria.class.getName()+" não foi encontrado!"));
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria criaCategoria(Categoria obj) {
		obj.setId(null); //Setando como nulo pq é o JPA quem define o ID
		return repository.save(obj);
	}
	
}
