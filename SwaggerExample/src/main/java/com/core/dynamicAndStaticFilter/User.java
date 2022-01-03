package com.core.dynamicAndStaticFilter;



import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;


@Data
@JsonFilter("someFilter")
public class User {
	
	@JsonIgnore
	@NonNull
	String id;
	
	@NonNull
	String name;
	
	@NonNull
	Date dob;
	
}
