package com.aula.controller;

import java.util.ArrayList;
import java.util.List;

import com.aula.model.User;
import com.aula.model.dao.UserDAO;

public class UserController {

	private User user;
	private UserDAO userDAO;
	private List<User> users;
	private String retornoForm;

	public UserController() {
		user = new User();
		userDAO = new UserDAO();
		users = new ArrayList<User>();
		retornoForm = "true";
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

	public String salvar() {
		String retorno = "";
		// Validação e Conversão

		// Gravação
		if (userDAO.salvar(user)) {
			retorno = "home";
			retornoForm = "false";
		} else {
			retorno = "formUser";
			retornoForm = "true";
		}

		return retorno;
	}

	public String getRetornoForm() {
		return retornoForm;
	}

}
