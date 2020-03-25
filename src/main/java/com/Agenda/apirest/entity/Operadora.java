package com.Agenda.apirest.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_operadora")
@Getter
@Setter
@AllArgsConstructor
public class Operadora extends AbstractEntity {

	private String nome;
	private Long codigo;
	private String categoria;
	private BigDecimal preco;

}
