package com.core.swagger;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("swagger")
public class SwaggerRestController {

	
//	URL : http://localhost:8080/swagger-ui/ 
//		URL 2 : http://localhost:8080/v2/api-docs

	
	
	
	@GetMapping("getTest")
	@Operation(summary = "To access user details you can use this api")
	@ApiResponses({
		@ApiResponse(responseCode = "-1",description = "error")
	})
	public User getTest() {
		return new User("1", "Deepak", new Date());
	}
	
	@PostMapping("getPost")
	public User getTest(@Parameter(description = "Mandatory ****") @Valid @RequestBody User user) {
		return new User("1", "Deepak", new Date());
	}
}
