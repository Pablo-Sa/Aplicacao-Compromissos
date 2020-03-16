package com.Agenda.apirest.repository;

import com.Agenda.apirest.entity.Contatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContatoRepository extends PagingAndSortingRepository<Contatos, Long> {
	 
}
