package org.MinhaEscola.escola.Controller;
	
	import java.util.List;

import org.MinhaEscola.escola.Repositorio.AlunoRepositorio;
import org.MinhaEscola.escola.model.Aluno_model;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/aluno")
	@CrossOrigin(origins = "", allowedHeaders = "")
	
	public class Aluno_Controller{
 
		@Autowired
		private AlunoRepositorio repository;
		
		@GetMapping
		public ResponseEntity<List<Aluno_model>> GetAll(){
			return ResponseEntity.ok(repository.findAll());	
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Aluno_model> GetById(@PathVariable long id){
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}  
		
		@GetMapping("/nome/{nome}") 
		public ResponseEntity<List<Aluno_model>> GetByNome(@PathVariable String nome){
			return ResponseEntity.ok(repository.findAllByNomeContaningIgnoreCase(nome));
		}
		
		@PostMapping
		public ResponseEntity<Aluno_model> post (@RequestBody Aluno_model aluno_model){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno_model));
		}
		
		@PutMapping
		public ResponseEntity<Aluno_model> put (@RequestBody Aluno_model aluno_model){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno_model));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}	
		
	}


