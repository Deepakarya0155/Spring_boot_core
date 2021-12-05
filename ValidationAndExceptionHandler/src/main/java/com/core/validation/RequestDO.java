package com.core.validation;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@MinorNotAllowedAnnotation(message = "Age must 18 >age",groups = {MinorValidationorder.class})
@GroupSequence({RequestDO.class,MinorValidationorder.class})
public class RequestDO {
	
	@NotNull(message="Name should not null")
	String name;
	
	@NotNull(message="Age should not null")
	Integer age;

}
