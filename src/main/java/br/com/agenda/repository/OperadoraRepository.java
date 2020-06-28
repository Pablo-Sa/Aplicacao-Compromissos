package br.com.agenda.repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.agenda.entity.Operadora;


public interface OperadoraRepository extends PagingAndSortingRepository <Operadora, Long>  {

}
