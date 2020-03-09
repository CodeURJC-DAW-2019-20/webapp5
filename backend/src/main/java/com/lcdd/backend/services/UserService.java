package com.lcdd.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.dbrepositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User findById(long id) {
		return userRepo.findById(id);
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public List<User> findAll(Sort sort){
		return userRepo.findAll(sort);
	}
	
	public User findByName(String name) {
		return userRepo.findByName(name);
	}
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public void deleteById(long id) {
		userRepo.deleteById(id);
	}
	
	public void deleteByUser(User user) {
		userRepo.delete(user);
	}
	
	public boolean createAnUser(User user) {
		if (userRepo.findByName(user.getName()) != null) {
			//already exist a registered user with this name
			return false;
		}
		if (user.getId() != null ){
			if (userRepo.findById(user.getId()) == null) {
				//already exist a registered user with this id
				return false;
			}
		}
		/*if (user.getPasswordHash() == null ){
			return false;
		}*/
		user.setPasswordHash(user.getPasswordHash());
		save(user);
		return true;
	}
	
}
