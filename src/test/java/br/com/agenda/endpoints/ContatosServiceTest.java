package br.com.agenda.endpoints;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import br.com.agenda.entity.Contatos;
import br.com.agenda.entity.Operadora;
import br.com.agenda.services.ContatosService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ContatosServiceTest {

	@Test
	void contextLoads() {

	}

	@Autowired
	private TestRestTemplate restTemplet;
	
	@LocalServerPort
	private int port;
	
	@MockBean
	private ContatosService contatosService;
	
	@Test
	public void testGetIDResponseStatusCode200() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		Contatos contact = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		contatosService.save(contact);
		BDDMockito.when(this.contatosService.findById(contact.getId())).thenReturn(contact);
		ResponseEntity<String> response = restTemplet.getForEntity("/contatos/"+contact.getId(), String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(400);
    	}
	
	@Test
	public void testGetResponseStatusCode200() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		Contatos contact = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		List<Contatos> listContact = new ArrayList<Contatos>();
		listContact.add(contact);
		BDDMockito.when(this.contatosService.findAll(null)).thenReturn(listContact);
		ResponseEntity<String> response = restTemplet.getForEntity("/contatos",  String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    	}
	
	
	@Test
	public void testGetResponseStatusCode404() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		Contatos contact = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		List<Contatos> listContact = new ArrayList<Contatos>();
		listContact.add(contact);
		BDDMockito.when(this.contatosService.findAll(null)).thenReturn(listContact);
		ResponseEntity<String> response = restTemplet.getForEntity("/contatosf", String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
		}
	
	
	@Test
	public void testPostResponseStatusCode200() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		Contatos contact = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		BDDMockito.when(this.contatosService.save(contact)).thenReturn(contact);
		ResponseEntity<String> response = restTemplet.postForEntity("/contatos", contact, String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	
	@Test
	public void testPostAllResponseStatusCode200() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		Contatos contactOne = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		Contatos contactTwo = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		List<Contatos> contactList = new ArrayList<>();
		contactList.add(contactOne);
		contactList.add(contactTwo);
		BDDMockito.when(this.contatosService.saveAll(contactList)).thenReturn(contactList);
		ResponseEntity<String> response = restTemplet.postForEntity("/allcontatos", contactList, String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void testPostAllResponseStatusCode404() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		Contatos contactOne = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		Contatos contactTwo = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		List<Contatos> contactList = new ArrayList<>();
		contactList.add(contactOne);
		contactList.add(contactTwo);
		BDDMockito.when(this.contatosService.saveAll(contactList)).thenReturn(contactList);
		ResponseEntity<String> response = restTemplet.postForEntity("/allcontatosf", contactList, String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
	}
	
	@Test
	public void testPostResponseStatusCode404() {
		Operadora operadoraTest = new Operadora("Tim", new Long(34), "Móvel", new BigDecimal(54.6));
		Contatos contact = new Contatos("Joao", "Batista", new Date(0), operadoraTest);
		contatosService.save(contact);
		BDDMockito.when(this.contatosService.save(contact)).thenReturn(contact);
		ResponseEntity<String> response = restTemplet.postForEntity("/contatosf", contact, String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);
	}
	
}
