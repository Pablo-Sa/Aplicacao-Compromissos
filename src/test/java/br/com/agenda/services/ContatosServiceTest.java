package br.com.agenda.services;

import java.math.BigDecimal;
import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.agenda.entity.Contatos;
import br.com.agenda.entity.Operadora;
import br.com.agenda.services.ContatosService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ContatosServiceTest {

	@Autowired
	private ContatosService contatosService;
	
	@Test
	void contextLoads() {

	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void save() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		Contatos contact = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		Contatos contactTest = contatosService.save(contact);
		Assertions.assertThat(contactTest.getNome()).isEqualTo("Joao");
		Assertions.assertThat(contactTest.getId()).isNotNull();
		Assertions.assertThat(contactTest.getSobrenome()).isEqualTo("Batista");
		Assertions.assertThat(contactTest.getDatainclusao()).isNotNull();
		Assertions.assertThat(contactTest.getOperadora().getNome()).isNotEmpty();
		Assertions.assertThat(contactTest.getOperadora().getCodigo()).isNotNull();
		Assertions.assertThat(contactTest.getOperadora().getCategoria()).isNotEmpty();
		Assertions.assertThat(contactTest.getOperadora().getPreco()).isNotNull();
	}

}
