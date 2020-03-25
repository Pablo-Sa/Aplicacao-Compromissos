package com.Agenda.apirest.Services;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.Agenda.apirest.entity.Operadora;
import com.Agenda.apirest.services.OperadoraService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class OperadoraServiceTest {

	@Autowired
	OperadoraService operadoraService;

	public void save() {
		Operadora operadoratest = new Operadora("Algar", new Long(24), "Móvel", new BigDecimal(65.5));
		Operadora operadoraDTO = operadoraService.save(operadoratest);
		Assertions.assertThat(operadoraDTO.getNome()).isNotEmpty();
		Assertions.assertThat(operadoraDTO.getCodigo()).isNotNull();
		Assertions.assertThat(operadoraDTO.getCategoria()).isEqualTo("Móvel");
		Assertions.assertThat(operadoraDTO.getPreco()).isNotNull();
	}

}
