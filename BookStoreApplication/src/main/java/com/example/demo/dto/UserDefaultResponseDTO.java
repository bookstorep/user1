package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDefaultResponseDTO  implements MyDTO{
	private String userName;
	private String password;
	private String role;
	
	
}
