package it.beTalent.nomiCognomi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beTalent.nomiCognomi.entities.Person;
import it.beTalent.nomiCognomi.repository.PersonRepo;

@Service

public class VGService {
	@Autowired
	private PersonRepo repo;
	
	public List<Person> listAll(){
		List<Person> lista = repo.findAll();
		return lista;
	}
	
	public void save(Person persona) {
		repo.save(persona);
	}
	
	public Person get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
    /*public List<Person> findByCat(String cat) {
    	return repo.findPersonByCat(cat);
    }*/
}
