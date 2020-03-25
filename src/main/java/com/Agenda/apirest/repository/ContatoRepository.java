package com.Agenda.apirest.repository;

import com.Agenda.apirest.entity.Contatos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends PagingAndSortingRepository<Contatos, Long> {
}
