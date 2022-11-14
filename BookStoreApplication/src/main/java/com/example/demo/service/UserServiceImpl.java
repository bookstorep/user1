package com.example.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository userRepository;	
	@Override
	public User addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		User savedUser=userRepository.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUSer() throws Exception {
		List<User> allUsers=userRepository.findAll();
		return allUsers;
		
		
	}

		@Override
	public User getUserByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.getUserByUserName(userName);
	}

	@Override
	public User getUserByRole(String role) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.getUserByRole(role);
	}

	@Override
	public  void delete(int userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

	
	@Override
	public User getUserByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.getUserByUserId(userId);
	}

	@Override
	public List<User> getUsersBetweenIds(int range1, int range2) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.getUsersBetweenIds(range1, range2);
	}

	/*@Override
	public User update(User user) throws Exception {
		// TODO Auto-generated method stub
		User existingUser=userRepository.findById(user.getUserId()).orElse(null);
		existingUser.setUserName(user.getUserName());
		existingUser.setRole(user.getRole());
		existingUser.setPassword(user.getPassword());
		return userRepository.save(existingUser);
	}*/

			

		


}
