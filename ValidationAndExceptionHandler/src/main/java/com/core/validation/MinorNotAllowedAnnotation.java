package com.core.validation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =MinorNotAllowedvalidation.class)
public @interface MinorNotAllowedAnnotation {
	
	String message() default "Minor";
	
	Class<?>[] groups() default {};
	
	public abstract Class<? extends Payload>[] payload() default {};
}

