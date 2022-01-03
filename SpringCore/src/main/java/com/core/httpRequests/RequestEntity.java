package com.core.httpRequests;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class RequestEntity {

	@Id
	Long userId;
	String firstName;
	String lastName;
	
}
