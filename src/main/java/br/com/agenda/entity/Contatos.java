package br.com.agenda.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_contatos")
@Getter
@Setter
@NoArgsConstructor
public class Contatos extends AbstractEntity {

	private String nome;
	private String sobrenome;
	private Date datainclusao;
	private Operadora operadora;
	
	
	@Builder
	public Contatos(
	 String nome,
	 String sobrenome,
	 Date datainclusao,
	 Operadora operadora) 
{
	this.nome = nome;
	this.sobrenome = sobrenome;
	this.datainclusao = datainclusao;
	this.operadora = operadora;
	}

}
