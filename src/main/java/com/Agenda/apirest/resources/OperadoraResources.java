package com.Agenda.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Agenda.apirest.entity.Operadora;
import com.Agenda.apirest.repository.OperadoraRepository;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OperadoraResources {

	 
	@Autowired
	OperadoraRepository operadoraRepository;
	
	
	@GetMapping("/operadora")
	public ResponseEntity<?> getAllOperadora(Pageable pageable){
		return new ResponseEntity<>(operadoraRepository.findAll(pageable), HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("/operadora")
	public ResponseEntity<?> saveOperadora(@RequestBody Operadora operadora){
		return new ResponseEntity<>(operadoraRepository.save(operadora), HttpStatus.OK);
 	}
	
}
