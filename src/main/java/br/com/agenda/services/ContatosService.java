package br.com.agenda.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.entity.Contatos;
import br.com.agenda.repository.ContatoRepository;

@Service
public class ContatosService {

	@Autowired
	public ContatoRepository contatoRepository;

	public Contatos save(Contatos contato) {
		return contatoRepository.save(contato);
	}

	public Iterable<Contatos> saveAll(Iterable<Contatos> contatos) {
		return contatoRepository.saveAll(contatos);
	}

	public Iterable<Contatos> findAll(org.springframework.data.domain.Pageable pageable) {
		return contatoRepository.findAll(pageable);
	}

	public Contatos findById(Long id) {
		return contatoRepository.findById(id).get();
	}

	public Contatos delete(Contatos entity) {
		contatoRepository.delete(entity);
		return entity;
	}

	public double deleteById(Long id) {
		contatoRepository.deleteById(id);
		return id;
	}	
}
