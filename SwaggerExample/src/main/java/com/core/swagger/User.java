package com.core.swagger;



import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

@ApiModel(description = "All about user DTO")
@Data
public class User {
	
	@NonNull
	@NotNull
	@Size(min = 3)
	@ApiModelProperty(notes = "Mandatory")
	String id;
	
	
	@NonNull
	@Size(min=5)
	String name;
	
	@NonNull
	@Past(message="Invalid date")
	@ApiModelProperty(notes="please Enter past date heres")
	Date dob;
	
	
	
	
	
}
