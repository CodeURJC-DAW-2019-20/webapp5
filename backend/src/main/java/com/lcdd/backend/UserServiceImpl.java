package com.lcdd.backend;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}
	
	@Override
	public User getUserById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}
	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = repository.findByUsername(user.getUsername());
		if (userFound.isPresent()) {
			throw new Exception("Username no disponible");
		}
		return true;
	}

	private boolean checkPasswordValid(User user) throws Exception {
		if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirm Password es obligatorio");
		}
		if ( !user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("Password y Confirm Password no son iguales");
		}
		return true;
	}


	@Override
	public User updateUser(User fromUser) throws Exception {
		User toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);
		return repository.save(toUser);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapUser(User from,User to) {
		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRole(from.getRole());
	}
}
