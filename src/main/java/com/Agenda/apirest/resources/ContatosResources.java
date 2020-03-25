package com.Agenda.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.Agenda.apirest.services.ContatosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Back-End Java - Aplicação Compromissos")
public class ContatosResources {

	@Autowired
	ContatosService contatosService;

	@ApiOperation(value = "Retorna Todos os Contatos")
	@GetMapping("/contatos")
	public ResponseEntity<?> getAllContatos(Pageable pageable) {
		return new ResponseEntity<>(contatosService.findAll(pageable), HttpStatus.OK);
	}

	@ApiOperation(value = "Busca Por ID")
	@GetMapping("/contatos/{id}")
	public ResponseEntity<?> getContatoId(@PathVariable("id") Long id) {
		verifyIfContactExists(id);
		return new ResponseEntity<>(contatosService.findById(id), HttpStatus.OK);
	}

	
	@ApiOperation(value = "Salva uma Lista de Contatos")
	@PostMapping("/allcontatos")
	public ResponseEntity<?> saveContatos(@RequestBody Iterable<Contatos> contatos) {
		contatosService.saveAll(contatos);
		return new ResponseEntity<>(contatos, HttpStatus.OK);
	}

	
	@ApiOperation(value = "Salva um Contato")
	@PostMapping(path = "/contatos",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveContato(@RequestBody Contatos contato) {
		return new ResponseEntity<>(contatosService.save(contato), HttpStatus.OK);
	}

	
	@ApiOperation(value = "Atualiza um Contato")
	@PutMapping("/contatos")
	public ResponseEntity<?> updateContato(@RequestBody Contatos contato) {
		verifyIfContactExists(contato.getId());
		return new ResponseEntity<>(contatosService.save(contato), HttpStatus.OK);
	}

	
	@ApiOperation(value = "Delete um Contato")
	@DeleteMapping("/contatos")
	public ResponseEntity<?> deleteContato(@RequestBody Contatos contato) {
		verifyIfContactExists(contato.getId());
		contatosService.delete(contato);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private void verifyIfContactExists(Long id) {
		if (!contatosService.findById(id).isPresent())
			throw new ResourcesNotFoundException("Contato Not Found by ID " + id);
	}
}
