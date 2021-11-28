package com.core.emailservice;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.core.io.FileSystemResource;

import lombok.Data;

@Data
public class EmailServiceRequest {

	private Optional<String> content=Optional.ofNullable(null);
	private Optional<Boolean> htmlflag=Optional.ofNullable(null);
	private Optional<String> subject=Optional.ofNullable(null);
	private Optional<String[]> to=Optional.ofNullable(null);
	private Optional<String[]> cc=Optional.ofNullable(null);
	private Map<String,FileSystemResource> inlinecontent=new HashMap<>();
	

	Map<String,FileSystemResource> files=new HashMap<>();
	
	public void addNewFile(String path) {
		File fl=new File(path);
		files.put(fl.getName(),new FileSystemResource(fl));
	}
	public void putInlineContent(String name,String path) {
		File fl=new File(path);
		inlinecontent.put(name,new FileSystemResource(fl));
	}
	
}
