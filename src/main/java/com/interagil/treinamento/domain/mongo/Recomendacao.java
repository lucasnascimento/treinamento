package com.interagil.treinamento.domain.mongo;

import org.springframework.data.annotation.Id;

public class Recomendacao {

	@Id private String id;
	private String nome;
	private String email;
	private Integer nota;
	private String recomendacao;
	private Integer hotelId;

	public Recomendacao(){

	}

	public Recomendacao(String nome, String email, Integer nota, String recomendacao, Integer hotelId) {
		this.nome = nome;
		this.email = email;
		this.nota = nota;
		this.recomendacao = recomendacao;
		this.hotelId = hotelId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
}
