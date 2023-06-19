package it.beTalent.nomiCognomi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beTalent.nomiCognomi.entities.User;
import it.beTalent.nomiCognomi.repository.UserRepo;

@Service

public class UserService {
	@Autowired
	private UserRepo uRepo;
	
	public List<User> listAll(){
		List<User> list = uRepo.findAll();
		return list;
	}
	
	public List<User> findByUsername(String username) {
        return  uRepo.findUserByUsername(username);
    }
    
    public List<User> getAllUsers() {
        return uRepo.findAll();
    }
    
    public void saveUser(User user) {
    	uRepo.save(user);
    }
    
    public void deleteUser(Long id) {
    	uRepo.deleteById(id);
    }
}
