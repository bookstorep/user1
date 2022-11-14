package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserService userService;

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/add")
	public ResponseEntity<String> addUsers(@RequestBody User user) {

		try {
			User savedUser = userService.addUser(user);
			String responseMsg = savedUser.getUserName() + " save with Id " + savedUser.getUserId();
			mylogs.info("A value is added ");
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		try {
			List<User> allExtractedUsers = userService.getAllUSer();
			return allExtractedUsers;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	@GetMapping("username/{searchUserName}")
	public User getUserByUserName(@PathVariable String searchUserName) throws Exception {
		return userService.getUserByUserName(searchUserName);
	}

	@GetMapping("userid/{searchUserId}")
	public User getUserByUserID(@PathVariable int searchUserId) throws Exception {
		return userService.getUserByUserId(searchUserId);
	}

	@GetMapping("userrole/{searchUserRole}")
	public User getUserByUserRole(@PathVariable String searchUserRole) throws Exception {
		return userService.getUserByRole(searchUserRole);
	}

	@DeleteMapping("/userid/{searchUserId}")
	public  String deleteUser(@PathVariable int searchUserId) {
		try {
			userService.delete(searchUserId);
			mylogs.info(" a user is deleted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return "user is deleted";
	}

	@GetMapping("/usersbyId")
	public List<User> usersById(@RequestParam int r1, @RequestParam int r2) throws Exception {

		return userService.getUsersBetweenIds(r1, r2);
	}

	@PutMapping("/user/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User userDetails) throws Exception {
		userService.getUserByUserId(userId);
		userDetails.setUserId(userId);
		User updateUser = userService.addUser(userDetails);
		return updateUser;
	}

}
