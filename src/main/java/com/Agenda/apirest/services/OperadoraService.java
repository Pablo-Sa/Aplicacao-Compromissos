package com.Agenda.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Agenda.apirest.entity.Operadora;
import com.Agenda.apirest.repository.OperadoraRepository;

@Service
public class OperadoraService {

	@Autowired
	OperadoraRepository operadoraRepository;

	public Operadora save(Operadora entity) {
		return operadoraRepository.save(entity);
	}

	public Iterable<Operadora> findAll(org.springframework.data.domain.Pageable pageable) {
		return operadoraRepository.findAll(pageable);
	}
	
}
