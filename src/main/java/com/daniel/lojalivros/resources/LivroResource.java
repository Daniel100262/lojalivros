package com.daniel.lojalivros.resources;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.daniel.lojalivros.domain.Livro;
import com.daniel.lojalivros.dtos.LivroDTO;
import com.daniel.lojalivros.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> procurarPeloID(@PathVariable Integer id){
		Livro obj = service.procuraPeloID(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
		
		List<Livro> livros = service.findAll(id_cat);
		List<LivroDTO> listaLivrosDTO = livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaLivrosDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro objLivroJSON){ //obj é um JSON com um Livro
		Livro novoLivro = service.update(id, objLivroJSON);
		return ResponseEntity.ok().body(novoLivro);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro objLivroJSON){ //obj é um JSON com um Livro
		Livro novoLivro = service.update(id, objLivroJSON);
		return ResponseEntity.ok().body(novoLivro);
	}
	
}

// localhost:8080/categorias/1
// put é quando atualiza o objeto inteiro, patch é quando atualiza só uma parte, tipo a descricao
