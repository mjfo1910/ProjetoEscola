package org.MinhaEscola.escola.Repositorio;

import java.util.List;

import org.MinhaEscola.escola.model.Aluno_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

 	public interface AlunoRepositorio extends JpaRepository <Aluno_model, Long> {
 		public List<Aluno_model> findAllByNomeContaningIgnoreCase (String nome);
 		
 	}



	

	


	
	
	

