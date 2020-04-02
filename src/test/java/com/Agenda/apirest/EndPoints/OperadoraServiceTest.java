package com.Agenda.apirest.EndPoints;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.Agenda.apirest.entity.Operadora;
import com.Agenda.apirest.services.OperadoraService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class OperadoraServiceTest {

	@Test
	void contextLoads() {

	}
	
	@Autowired
	private TestRestTemplate restTemplet;
	
	@LocalServerPort
	private int port;
	
	@MockBean
	private OperadoraService operadoraService;
	
	@Test
	public void testPostResponseStatusCode200() {
		Operadora operadoratest = new Operadora("Algar", new Long(24), "Móvel", new BigDecimal(65.5));
		BDDMockito.when(this.operadoraService.save(operadoratest)).thenReturn(operadoratest);
		ResponseEntity<Operadora> response = restTemplet.postForEntity("/operadora", operadoratest, Operadora.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody().getCodigo()).isEqualTo(24);
	}

	
	@Test
	public void testPostResponseStatusCode404() {
		Operadora operadoratest = new Operadora("Algar", new Long(24), "Móvel", new BigDecimal(65.5));
		BDDMockito.when(this.operadoraService.save(operadoratest)).thenReturn(operadoratest);
		ResponseEntity<Operadora> response = restTemplet.postForEntity("/foperadora", operadoratest, Operadora.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
	}
	
	@Test
	public void testGetIDResponseStatusCode200() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		BDDMockito.when(this.operadoraService.findById(operadoraTest.getId())).thenReturn(operadoraTest);
		ResponseEntity<String> response = restTemplet.getForEntity("/operadora",  String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
   	}
	
	@Test
	public void testGetIDResponseStatusCode404() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		BDDMockito.when(this.operadoraService.findById(operadoraTest.getId())).thenReturn(operadoraTest);
		ResponseEntity<String> response = restTemplet.getForEntity("/operadoraf",  String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
   	}
}
