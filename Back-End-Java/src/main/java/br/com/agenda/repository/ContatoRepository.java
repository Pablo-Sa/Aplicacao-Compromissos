package br.com.agenda.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.agenda.entity.Contatos;

public interface ContatoRepository extends PagingAndSortingRepository<Contatos, Long> {
	public void deleteById(Long id);
}
