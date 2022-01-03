package com.core.apiversion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class APiVersionDemoRestController {

	

	@GetMapping(value="person",params = "v=1")
	public String PersonAPIV1() {
		return "param v1";
	}
	
	
	
	@GetMapping(value="person",params = "v=2")
	public String PersonAPIV2() {
		return "param v2";
	}
	
	//header   v=1
	@GetMapping(value="personH",headers = "v=1")
	public String PersonAPIheadersV1() {
		return "Header v1";
	}
	
	
	//header   v=2
	@GetMapping(value="personH",headers = "v=2")
	public String PersonAPIHeadersV2() {
		return "Header v2";
	}
	
	// header Accept :  application/v1+json
	@GetMapping(value="personH",produces = "application/v1+json")
	public String PersonAPIProduceV1() {
		return "application/v1+json";
	}
	
	
	// header Accept :  application/v2+json
	@GetMapping(value="personH",produces = "application/v2+json")
	public String PersonAPIProduceV2() {
		return "application/v2+json";
	}
}
