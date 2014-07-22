package com.aula.model.dao;

import com.aula.model.User;

public class UserDAO {

	public boolean salvar(User user) {
		// TODO Fazer a conexão com o DB e salvar o obj.
		
		System.out.println(user.getNome());
		System.out.println(user.getCpf());

		return true;
	}

}
