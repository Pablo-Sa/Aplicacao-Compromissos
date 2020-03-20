package com.Agenda.apirest.resources;



import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

import com.Agenda.apirest.entity.Contatos;
import com.Agenda.apirest.errors.ResourcesNotFoundException;
import com.Agenda.apirest.repository.ContatoRepository;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContatosResources {
	
	@Autowired
	ContatoRepository contatoRepository;
	
	
	@GetMapping("/contatos")
	public ResponseEntity<?> getAllContatos(Pageable pageable){
		return new ResponseEntity<>(contatoRepository.findAll(pageable), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/contatos/{id}")
	public ResponseEntity<?>getContatoId(@PathVariable("id")Long id){
		verifyIfContactExists(id);
	 return new ResponseEntity<>(contatoRepository.findById(id),  HttpStatus.OK);
	}
	
	
	@PostMapping("/allcontatos")
	public ResponseEntity<?> saveContatos(@Valid @RequestBody ArrayList<Contatos> contato){
		for (Contatos contatos : contato) {
			contatoRepository.save(contatos);
		}
		return new ResponseEntity<>(contato,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/contatos")
	public ResponseEntity<?> saveContato(@Valid @RequestBody Contatos contato){
		return new ResponseEntity<>(contatoRepository.save(contato),HttpStatus.OK); 
	}
	
	
	@PutMapping("/contatos")
	public ResponseEntity<?> updateContato(@RequestBody Contatos contato){
		verifyIfContactExists(contato.getId());
		return new ResponseEntity<>(contatoRepository.save(contato),HttpStatus.OK); 
	}
	
	
	
	
	@DeleteMapping("/contatos")
	public ResponseEntity<?> deleteContato(@RequestBody Contatos contato){
		verifyIfContactExists(contato.getId());
		contatoRepository.delete(contato);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	private void verifyIfContactExists(Long id) {
		if (!contatoRepository.findById(id).isPresent()) 
			 throw new ResourcesNotFoundException("Contato Not Found by ID "+ id);	
	}
}
