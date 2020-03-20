package com.Agenda.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Agenda.apirest.entity.Contatos;
import com.Agenda.apirest.repository.ContatoRepository;

@Service
public class ContatosService {

	@Autowired
	public ContatoRepository contatoRepository;

	public Contatos save(Contatos entity) {
		return contatoRepository.save(entity);
	}

	public Iterable<Contatos> findAll(org.springframework.data.domain.Pageable pageable) {
		return contatoRepository.findAll(pageable);
	}

	public Optional<Contatos> findById(Long id) {
		return contatoRepository.findById(id);
	}
	
	public Contatos delete(Contatos entity) {
		contatoRepository.delete(entity);
		return entity;
	}

}
