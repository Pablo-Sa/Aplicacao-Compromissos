package com.Agenda.apirest.Resources;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.Agenda.apirest.entity.Operadora;
import com.Agenda.apirest.services.OperadoraService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EndPointOperadora {

	@Test
	void contextLoads() {

	}

	@Autowired
	private TestRestTemplate restTemplet;

	@MockBean
	OperadoraService operadoraService;

	@Test
	public void testGetAllResponseDTOReturnStatusCode200() {
		Operadora operadoraTestOne = new Operadora("Tim", new Long(35), "Móvel", new BigDecimal(41.3));
		Operadora operadoraTestTwo = new Operadora("Vivo", new Long(45), "Fixo", new BigDecimal(88.3));
		Operadora operadoraTestTree = new Operadora("Algar", new Long(98), "Fixo", new BigDecimal(6.93));
		Operadora operadoraTestFour = new Operadora("GVT", new Long(40), "Móvel", new BigDecimal(98.3));
		Operadora operadoraTestFive = new Operadora("Oi", new Long(25), "Móvel", new BigDecimal(586.3));
		List<Operadora> OperadoraDTOList = new ArrayList<>(Arrays.asList(operadoraTestOne, operadoraTestTwo,
				operadoraTestTree, operadoraTestFour, operadoraTestFive));
		BDDMockito.when(operadoraService.findAll(null)).thenReturn(OperadoraDTOList);
		ResponseEntity<?> response = restTemplet.getForEntity("/operadora", OperadoraDTOList.getClass());
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void testPostResponseDTOReturnStatusCode200() {
		Operadora operadoraTest = new Operadora("Tim", new Long(52), "Móvel", new BigDecimal(68.8));
		BDDMockito.when(operadoraService.save(operadoraTest)).thenReturn(operadoraTest);
		ResponseEntity<Operadora> response = restTemplet.postForEntity("/operadora", operadoraTest, Operadora.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody().getNome()).isEqualTo("Tim");
		Assertions.assertThat(response.getBody().getCategoria()).isEqualTo("Móvel");
		Assertions.assertThat(response.getBody().getPreco()).isNotNull();
	}
	
	@Test
	public void testPostResponseDTOReturnStatusCode404() {
		Operadora operadoraTest = new Operadora("Tim", new Long(52), "Móvel", new BigDecimal(68.8));
		BDDMockito.when(operadoraService.save(operadoraTest)).thenReturn(operadoraTest);
		ResponseEntity<Operadora> response = restTemplet.postForEntity("/operadoraf", operadoraTest, Operadora.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
	}

}
