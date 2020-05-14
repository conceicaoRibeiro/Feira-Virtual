package br.com.senac.feiravirtual.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "Vaga")
public class Vaga extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = true)
	private String descricao;

	@NotBlank
	@Size(max = 255, min = 3)
	private String codigoSenac;

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = true)
	private String atividadesPrincipais;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate inicio;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fim;
	

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = true)
	private String cargo;



	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAtividadesPrincipais() {
		return atividadesPrincipais;
	}

	public void setAtividadesPrincipais(String atividadesPrincipais) {
		this.atividadesPrincipais = atividadesPrincipais;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCodigoSenac() {
		return codigoSenac;
	}

	public void setCodigoSenac(String codigoSenac) {
		this.codigoSenac = codigoSenac;
	}

}
