package com.example.demo.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDefaultResponseDTO;
import com.example.demo.dto.UserPostCreatedResponseDTO;
import com.example.demo.entity.User;

@Component
@Scope("singleton")
public class UserDTOConvertor {
	public static UserDefaultResponseDTO  getUserDefaultDTO(User user)
	{
		UserDefaultResponseDTO dto = new UserDefaultResponseDTO(
				                 user.getUserName(), 
				                 
				                 user.getRole(),
				                 user.getPassword()); 
				                
		return dto;
	}
	
	
	
	
	/*public static UserPostCreatedResponseDTO getPostCreatedDTO(User user,Order order)
	{
		UserPostCreatedResponseDTO dto = new UserPostCreatedResponseDTO(
				 user.getUserName(), 
                 user.getUserId(), 
                 order.getDescription(),
                 "order Added "+order.getDate()
                 );
				 
				 return dto;
	}*/

}
