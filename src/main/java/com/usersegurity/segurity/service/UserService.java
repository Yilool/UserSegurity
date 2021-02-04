package com.usersegurity.segurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.usersegurity.model.entity.Cliente;
import com.usersegurity.model.repository.ClienteRepository;
import com.usersegurity.segurity.model.User;
import com.usersegurity.segurity.model.dto.UserDTO;
import com.usersegurity.segurity.model.dto.UserDTOConverter;
import com.usersegurity.segurity.repo.UserRepository;
import com.usersegurity.services.ClienteService;


@Service("userService")
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserDTOConverter converter;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
	}
	
	
	public User createNewUser(UserDTO userDTO, Integer id) {
		User u = repository.save(converter.fromUserDTOToUser(userDTO));
		
		Cliente c = clienteRepository.findClienteById(id);
		
		clienteService.updateClient(c, u);
		
		return u;
	}
	

}
