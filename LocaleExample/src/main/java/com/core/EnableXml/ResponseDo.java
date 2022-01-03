package com.core.EnableXml;

import lombok.Data;
import lombok.NonNull;

@Data
public class ResponseDo {

	@NonNull
	String name;
	@NonNull
	String age;
}
