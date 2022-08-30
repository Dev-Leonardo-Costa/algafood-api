package com.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Embeddable
public class Endereco {
	
	@Column(name = "endereco_cep")
	private String cep;
	@Column(name = "endereco_logadouro")
	private String logadouro;
	@Column(name = "endereco_numero")
	private String numero;
	@Column(name = "endereco_complemento")
	private String complemento;
	@Column(name = "endereco_bairro")
	private String bairro;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;
}
