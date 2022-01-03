package com.core.locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locale")
public class LocaleController {

	@Autowired
	private MessageSource messageSourceObj;
	
	
//	Header    ||  Accept-Language = IN
	@GetMapping("test")
	public String test() {
		System.out.println(LocaleContextHolder.getLocale());
		return messageSourceObj.getMessage("msg", null, LocaleContextHolder.getLocale());
	}
	
	
		
	

}
