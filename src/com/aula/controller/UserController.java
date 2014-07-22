package com.aula.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.aula.model.User;
import com.aula.model.dao.UserDAO;

@ManagedBean
public class UserController {

	private User user;
	private UserDAO jpa;
	private List<User> users;
	private String exibeForm;

	public UserController() {
		user = new User();
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("loja");
		UserDAO jpa = new UserDAO(factory);
		users = new ArrayList<User>();
		exibeForm = "false";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	public String novo(){
		exibeForm = "true";
		return null;
	}
	
	
	public String salvar() {
		jpa.create(user);
		exibeForm = "false";
		return null;
	}

	public String getExibeForm() {
		return exibeForm;
	}

}
