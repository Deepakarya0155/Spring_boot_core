package com.core.hateos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.httpRequests.RequestEntity;
import com.core.httpRequests.RequestRepo;

@RestController
@RequestMapping("hateos")
public class HateosRestController {

	@Autowired
	RequestRepo requestRepo;
	
	@GetMapping("request")
	public List<EntityModel<RequestEntity>> getRequestMethod() {
		List<EntityModel<RequestEntity>> response=new ArrayList<>();
		
		
		
		for(RequestEntity rs:requestRepo.findAll()) {
		
			EntityModel<RequestEntity> em = EntityModel.of(rs);

			WebMvcLinkBuilder builder = WebMvcLinkBuilder.linkTo(
					WebMvcLinkBuilder.methodOn(this.getClass(), rs.getUserId()).getRequestMethod2(rs.getUserId())
					);
			em.add(builder.withRel("viewsingledetails"));

			response.add(em);
		}
		return response;
	}
	
	@GetMapping("request/{id}")
	public RequestEntity getRequestMethod2(@PathVariable("id") Long id) {
			return requestRepo.findById(id).get();
	}
}
