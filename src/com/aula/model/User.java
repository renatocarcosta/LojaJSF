package com.aula.model;

import java.util.Calendar;
import java.util.Date;


public class User {
	private int id;
	private String nome;
	private String user;
	private String pass;
	private String cpf;
	private Date dataNascimento;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean login() {
		if (!this.user.trim().isEmpty() && !this.pass.trim().isEmpty()) {
			// Aqui será mockado o acesso ao banco de dados
			// TODO Implementar o acesso ao BD
			this.nome = "Luciano Monteiro";
			this.cpf = "456456456";
			Calendar data = Calendar.getInstance();
			data.set(1975, 3, 24);
			this.dataNascimento = data.getTime();
			this.email = "lucams@gmail.com";
			return true;
		}
		return false;
	}

}
