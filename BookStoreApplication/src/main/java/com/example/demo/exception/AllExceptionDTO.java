package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllExceptionDTO {
	
	
	private String msg;
	private String userInput;
	private String dateAndTime;

}
