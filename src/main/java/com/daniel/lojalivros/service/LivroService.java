package com.daniel.lojalivros.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
}
