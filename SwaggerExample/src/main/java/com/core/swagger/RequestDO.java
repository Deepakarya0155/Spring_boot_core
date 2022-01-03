package com.core.swagger;

import lombok.Data;
import lombok.NonNull;

@Data
public class RequestDO {
	@NonNull
	String name;
	@NonNull
	String age;
}
