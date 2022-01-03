package com.core.EnableXml;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("xml")
public class XmlController {

	
	@GetMapping("test")
	public ResponseDo test() {
		return new ResponseDo("Deepak","26");
	}
}
