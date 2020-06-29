package br.com.agenda.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_operadora")
@Getter
@Setter
@NoArgsConstructor
public class Operadora extends AbstractEntity {

	private String nome;
	private Long codigo;
	private String categoria;
	private BigDecimal preco;

	@Builder
	public Operadora(
			String nome,
			Long codigo,
			String categoria,
			BigDecimal preco) 
	{
		this.nome = nome;
		this.codigo = codigo;
		this.categoria = categoria;
		this.preco = preco;
	}

}
