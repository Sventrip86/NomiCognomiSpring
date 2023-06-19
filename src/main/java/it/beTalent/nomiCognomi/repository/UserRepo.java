package it.beTalent.nomiCognomi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beTalent.nomiCognomi.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{

	 List<User> findUserByUsername(String username);
}
