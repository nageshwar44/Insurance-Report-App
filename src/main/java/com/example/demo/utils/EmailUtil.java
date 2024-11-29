package com.example.demo.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;



@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String subject, String body, String to, File f) {
		System.out.println("sendemail is called"+to);
		try {
			MimeMessage mimeMessage=mailSender.createMimeMessage();
			
			
			
			MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,true);
			helper.setSubject(subject);
			helper.setText(body,true);
			helper.setTo(to);
			helper.addAttachment("plans-info", f);
			mailSender.send(mimeMessage);
			System.out.println("Email sent successfully to: " +to);
		} catch (Exception e) {
			System.err.println("Failed to send email: " + e.getMessage()); e.printStackTrace();
		}
		return true;
	}

}
