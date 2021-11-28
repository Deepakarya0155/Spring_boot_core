package com.core.emailservice;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailsender; 

	public Boolean sendMail(EmailServiceRequest request) throws MessagingException {
		MimeMessage mimeMessage=mailsender.createMimeMessage();
		
		
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		
		if(request.getTo().isPresent()) {
			helper.setTo(request.getTo().get());
		}else {
			System.out.println("Please specify TO");
			return false;
		}
		
		if(request.getCc().isPresent()) {
			helper.setCc(request.getCc().get());
		}
		
		
		
		
		if(request.getSubject().isPresent()) {
			helper.setSubject(request.getSubject().get());
		}
		
		if(request.getContent().isPresent()) {
			if(request.getHtmlflag().isPresent()) {
				helper.setText(request.getContent().get(),request.getHtmlflag().get());
			}
			else {
				helper.setText(request.getContent().get());
			}
		}

		request.getFiles().forEach((arg0, arg1) -> {
			try {
				helper.addAttachment(arg0, arg1);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		request.getInlinecontent().forEach((t, u) -> {
			try {
				helper.addInline(t, u);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		mailsender.send(mimeMessage);
		return true;

	}
	
	public void test() {
		
		try {
			
			EmailServiceRequest obj=new EmailServiceRequest();
		
			obj.setTo(Optional.of(new String[] {"Deepakarya0155@gmail.com"}));
			obj.setContent(Optional.of("<h1>Hello world!</h1><img src='cid:img1'>"));
			obj.setHtmlflag(Optional.ofNullable(true));
			obj.setSubject(Optional.ofNullable("TESTING"));
			
			obj.addNewFile("C:\\Users\\Deepa\\learning\\git_repositoris\\Spring_boot_core\\SpringCore\\src\\main\\resources\\application.properties");
			obj.addNewFile("C:\\Users\\Deepa\\learning\\git_repositoris\\Spring_boot_core\\SpringCore\\src\\main\\resources\\logback.xml");
			obj.putInlineContent("img1", "C:\\Users\\Deepa\\Personal\\office\\photo.jpeg");
			
			sendMail(obj);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
