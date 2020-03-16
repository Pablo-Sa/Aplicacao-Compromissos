package com.Agenda.apirest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="tb_contatos")
public class Contatos extends AbstractEntity{
	
	 @NotEmpty
	 private String nome;
	 private String Sobrenome;
	 private Date   datainclusao;

	 public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}
	public Date getDatainclusao() {
		return datainclusao;
	}
	public void setDatainclusao(Date datainclusao) {
		this.datainclusao = datainclusao;
	}

}
