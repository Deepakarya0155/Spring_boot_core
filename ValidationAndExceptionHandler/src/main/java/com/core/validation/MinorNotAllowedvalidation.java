package com.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class MinorNotAllowedvalidation implements ConstraintValidator<MinorNotAllowedAnnotation, RequestDO>{

	@Override
	public boolean isValid(RequestDO value, ConstraintValidatorContext context) {
		if(value.getAge()<18) {
			return false;
		}else {
			return true;
		}
		
	}
	
}