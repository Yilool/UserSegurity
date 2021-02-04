package com.usersegurity.segurity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usersegurity.segurity.model.User;



public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByUsername(String username);
}
