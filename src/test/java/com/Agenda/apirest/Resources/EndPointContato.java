package com.Agenda.apirest.Resources;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.Agenda.apirest.entity.Contatos;
import com.Agenda.apirest.entity.Operadora;
import com.Agenda.apirest.services.ContatosService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EndPointContato {

	@Test
	void contextLoads() {

	}

	@Autowired
	private TestRestTemplate restTemplet;
	
	@LocalServerPort
	private int port;

	@MockBean
	private ContatosService contatoService;

	@Test
	public void testGetAllResponseDTOReturnStatusCode200() {
		Contatos contactTestOne = new Contatos("Pablo", "Vinícius", new Date(0),
				new Operadora("Tim", new Long(19), "Fixo", new BigDecimal(65.5)));
		Contatos contactTestTwo = new Contatos("Joao", "Pedro", new Date(0),
				new Operadora("Vivo", new Long(19), "Celular", new BigDecimal(65.5)));
		Contatos contactTestTree = new Contatos("Cleidiane", "Cardoso", new Date(0),
				new Operadora("Algar", new Long(19), "Fixo", new BigDecimal(65.5)));
		Contatos contactTestFour = new Contatos("Ariane", "Motta", new Date(0),
				new Operadora("GVT", new Long(19), "Fixo", new BigDecimal(65.5)));
		Contatos contactTestFive = new Contatos("Juliana", "India", new Date(0),
				new Operadora("Embratel", new Long(19), "Móvel", new BigDecimal(65.5)));
		List<Contatos> contatosDTOList = new ArrayList<>(
				Arrays.asList(contactTestOne, contactTestTwo, contactTestTree, contactTestFour, contactTestFive));
		BDDMockito.when(contatoService.findAll(null)).thenReturn(contatosDTOList);
		ResponseEntity<?> response = restTemplet.getForEntity("/contatos", contatosDTOList.getClass());
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void testPostResponseDTOReturnStatusCode200() {
		Contatos contactTest = new Contatos("Pablo", "Vinícius", new Date(0),
				new Operadora("Tim", new Long(19), "Fixo", new BigDecimal(65.5)));
		BDDMockito.when(contatoService.save(contactTest)).thenReturn(contactTest);
		ResponseEntity<Contatos> response = restTemplet.postForEntity("/contatos", contactTest, Contatos.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody().getNome()).isEqualTo("Pablo");
		Assertions.assertThat(response.getBody().getSobrenome()).isEqualTo("Vinícius");
		Assertions.assertThat(response.getBody().getDatainclusao()).isNotNull();
		Assertions.assertThat(response.getBody().getOperadora().getNome()).isEqualTo("Tim");
	}

	@Test
	public void testPostResponseDTOReturnStatusCode404() {
		Contatos contactTest = new Contatos("Pablo", "Vinícius", new Date(0),
				new Operadora("Tim", new Long(19), "Fixo", new BigDecimal(65.5)));
		BDDMockito.when(contatoService.save(contactTest)).thenReturn(contactTest);
		ResponseEntity<Contatos> response = restTemplet.postForEntity("/contatosf", contactTest, Contatos.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
	}

	@Test
	public void testPostAllResponseDTOReturnStatusCode200() {
		Contatos contactTestOne = new Contatos("Pablo", "Vinícius", new Date(0),
				new Operadora("Tim", new Long(19), "Fixo", new BigDecimal(65.5)));
		Contatos contactTestTwo = new Contatos("Joao", "Pedro", new Date(0),
				new Operadora("Vivo", new Long(19), "Celular", new BigDecimal(65.5)));
		Contatos contactTestTree = new Contatos("Cleidiane", "Cardoso", new Date(0),
				new Operadora("Algar", new Long(19), "Fixo", new BigDecimal(65.5)));
		Contatos contactTestFour = new Contatos("Ariane", "Motta", new Date(0),
				new Operadora("GVT", new Long(19), "Fixo", new BigDecimal(65.5)));
		Contatos contactTestFive = new Contatos("Juliana", "India", new Date(0),
				new Operadora("Embratel", new Long(19), "Móvel", new BigDecimal(65.5)));
		Iterable<Contatos> contatosDTOList = new ArrayList<>(
				Arrays.asList(contactTestOne, contactTestTwo, contactTestTree, contactTestFour, contactTestFive));
		BDDMockito.when(contatoService.saveAll(contatosDTOList)).thenReturn(contatosDTOList);
		ResponseEntity<?> response = restTemplet.postForEntity("/allcontatos", contatosDTOList,
				contatosDTOList.getClass());
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void testPostAllResponseDTOReturnStatusCode404() {
		Contatos contactTestOne = new Contatos("Pablo", "Vinícius", new Date(0),
				new Operadora("Tim", new Long(19), "Fixo", new BigDecimal(65.5)));
		Contatos contactTestTwo = new Contatos("Joao", "Pedro", new Date(0),
				new Operadora("Vivo", new Long(19), "Celular", new BigDecimal(65.5)));
		Contatos contactTestTree = new Contatos("Cleidiane", "Cardoso", new Date(0),
				new Operadora("Algar", new Long(19), "Fixo", new BigDecimal(65.5)));
		Contatos contactTestFour = new Contatos("Ariane", "Motta", new Date(0),
				new Operadora("GVT", new Long(19), "Fixo", new BigDecimal(65.5)));
		Contatos contactTestFive = new Contatos("Juliana", "India", new Date(0),
				new Operadora("Embratel", new Long(19), "Móvel", new BigDecimal(65.5)));
		Iterable<Contatos> contatosDTOList = new ArrayList<>(
				Arrays.asList(contactTestOne, contactTestTwo, contactTestTree, contactTestFour, contactTestFive));
		BDDMockito.when(contatoService.saveAll(contatosDTOList)).thenReturn(contatosDTOList);
		ResponseEntity<?> response = restTemplet.postForEntity("/allcontatosf", contatosDTOList, String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
	}

}
