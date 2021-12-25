package com.core.httpRequests;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("http")
public class RestCont {

	@Autowired
	RequestRepo requestRepo;
	
	@GetMapping("request")
	public List<RequestEntity> getRequestMethod() {
		return requestRepo.findAll();
	}
	
	@GetMapping("request/{id}")
	public Optional<RequestEntity> getRequestMethod(@PathVariable("id") Long id) {
			return requestRepo.findById(id);
	}
	
	@PostMapping("request")
	public ResponseEntity postRequestMethod(@RequestBody RequestEntity request) {
			 requestRepo.save(request);
			 return new ResponseEntity(HttpStatus.CREATED);
	}

	@DeleteMapping("request/{id}")
	public ResponseEntity<String> deleteRequestMethod(@PathVariable("id") Long id) {
			 requestRepo.deleteById(id);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	
	@PatchMapping("request/{id}")
	public ResponseEntity<String> PathRequestMethod(@PathVariable("id") Long id,@RequestBody Map<String,Object> map) {
			
			Optional<RequestEntity> request=this.getRequestMethod(id);
			
			
			if(request.isPresent()) {
				RequestEntity req=request.get();
					map.forEach((k,v)->{
						 Class classname=RequestEntity.class;
						 
						try {
							Field field=classname.getDeclaredField(k);
							
							field.set(req,v);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
				this.postRequestMethod(req);
			}
			return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}
}
