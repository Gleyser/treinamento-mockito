package br.com.treinamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@NotNull
	@NotBlank
	@Column(name = "username")
	private String nome;

	@NotNull
	@NotBlank
	@Column(name = "password")
	private String senha;

	@NotNull
	@NotBlank
	@Email
	private String email;		

	public Usuario(@NotNull @NotBlank String nome) {
		this.nome = nome;
	}

	public Usuario(@NotNull @NotBlank String nome, @NotNull @NotBlank @Email String email, @NotNull @NotBlank String password) {		
		this.nome = nome;
		this.email = email;
		this.senha = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
	
