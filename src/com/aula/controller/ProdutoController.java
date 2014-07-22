package com.aula.controller;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.aula.model.Produto;
import com.aula.model.dao.ProdutoDAO;

public class ProdutoController {

	private Produto produto;
	private String retornoForm;

	public ProdutoController() {
		produto = new Produto();
		retornoForm = "true";
	}

	public String cadastrar() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("loja");
		ProdutoDAO jpa = new ProdutoDAO(factory);
		jpa.create(produto);
		retornoForm = "false";
		return "";
	}

	public List<Produto> getLista() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("loja");
		ProdutoDAO jpa = new ProdutoDAO(factory);
		return jpa.findProdutoEntities();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getRetornoForm() {
		return retornoForm;
	}

	public void setRetornoForm(String retornoForm) {
		this.retornoForm = retornoForm;
	}
	
	
}
