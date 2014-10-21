package com.aula.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.aula.model.User;
import com.aula.model.dao.UserDAO;
import com.aula.model.dao.exceptions.NonexistentEntityException;
import com.aula.model.utils.Messages;

@ManagedBean
@SessionScoped
public class UserController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4490146538557291094L;
	private User user;
	private UserDAO jpa;
	private List<User> users;
	private String exibeForm;

	public UserController() {
		user = new User();
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("loja");
		jpa = new UserDAO(factory);
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
		this.users.clear();
		this.users.addAll(jpa.findUserEntities());
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String novo() {
		user = new User();
		exibeForm = "true";
		return null;
	}

	public String editar(User user) {
		this.user = user;
		exibeForm = "true";
		return null;
	}

	public void salvar() {
		try {
			if (user.getId() != null && user.getId() != 0) {
				jpa.edit(user);
			} else {
				jpa.save(user);
			}
		} catch (NonexistentEntityException e) {
			Messages.addMessage("Tabela não existe", e.getLocalizedMessage());
		} catch (Exception e) {
			Messages.addMessage("Erro ao salvar", e.getLocalizedMessage());
		}
		exibeForm = "false";
	}

	public String getExibeForm() {
		return exibeForm;
	}

	public String excluir(User user) {
		this.user = user;
		try {
			jpa.destroy(user.getId());
		} catch (NonexistentEntityException e) {
			Messages.addMessage("Erro ao excluir", e.getLocalizedMessage());
		}
		exibeForm = "false";
		return null;
	}

}
