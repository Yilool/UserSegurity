package com.usersegurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersegurity.model.entity.Cliente;
import com.usersegurity.model.repository.ClienteRepository;
import com.usersegurity.segurity.model.User;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository cr;
	
	public Cliente postClient(Cliente c) {
		return cr.save(c);
	}
	
	public Cliente updateClient(Cliente c, User u) {
		c.setUser(u);
		
		return cr.save(c);
	}
}
