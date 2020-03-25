package com.Agenda.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.Agenda.apirest.entity.Contatos;

public interface ContatoRepository extends PagingAndSortingRepository<Contatos, Long> {
}
