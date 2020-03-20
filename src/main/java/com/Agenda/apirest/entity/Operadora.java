package com.Agenda.apirest.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="tb_operadora")
public class Operadora extends AbstractEntity{
	
	private String nome;
	private Long   codigo;
	private String categoria;
	private BigDecimal preco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
		
}
