package it.beTalent.nomiCognomi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beTalent.nomiCognomi.entities.Person;

public interface PersonRepo  extends JpaRepository<Person, Long>{
	
	
	//List<Person> findUserByUsr(String username);


}
