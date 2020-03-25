package com.Agenda.apirest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_contatos")
@Getter
@Setter
@AllArgsConstructor
public class Contatos extends AbstractEntity {

	private String nome;
	private String Sobrenome;
	private Date datainclusao;
	private Operadora operadora;

}
