package com.invicto.streamingPlatform.services.impl;

import com.invicto.streamingPlatform.persistence.model.User;
import com.invicto.streamingPlatform.persistence.repository.UserRepository;
import com.invicto.streamingPlatform.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void createUser(User user) {
		if (userRepository.existsById(user.getId())) {

			// Throw userAlreadyExists exception

		}
		userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		if (!userRepository.existsById(user.getId())) {

			// Throw userIsNotExist exception

		}
		userRepository.delete(user);
	}

	@Override
	public void updateUser(User user) {
		if (!userRepository.existsById(user.getId())) {

			// Throw userIsNotExist exception

		}
		userRepository.save(user);
	}

	@Override
	public Optional<User> findByLogin(String login) {
		Optional<User> user = userRepository.findByLogin(login);
		return user;
	}

	@Override
	public Optional<User> findByEmailAddress(String emailAddress) {
		Optional<User> user = userRepository.findByEmailAddress(emailAddress);
		return user;
	}

	@Override
	public Optional<User> findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
}