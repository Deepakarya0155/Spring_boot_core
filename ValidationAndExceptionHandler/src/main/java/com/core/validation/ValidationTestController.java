package com.core.validation;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationTestController {

	@PostMapping("test")
	public ResponseEntity<RequestDO> test(@Valid @RequestBody RequestDO request) {
		
			return new ResponseEntity(request,HttpStatus.OK);
	}
	
	
}
