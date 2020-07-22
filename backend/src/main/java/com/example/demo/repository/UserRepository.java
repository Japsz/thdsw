package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	void save(Optional<User> userToUpdate);
	List<User> findByUsernameAndPassword(String username, String password);
}
