package com.core.exceptHandler;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;

@Data
public class CustomeExcption /* extends Exception */{
	@NonNull
	String msg;
	@NonNull
	Date time;
	
	@NonNull
	String defaultmsg;

}
