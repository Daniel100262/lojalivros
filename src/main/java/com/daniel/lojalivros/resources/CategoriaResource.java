package com.daniel.lojalivros.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.lojalivros.domain.Categoria;
import com.daniel.lojalivros.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> procurarPeloID(@PathVariable Integer id){
		Categoria obj = service.procuraPeloID(id);
		return ResponseEntity.ok().body(obj);
	}
}

// localhost:8080/categorias/1

