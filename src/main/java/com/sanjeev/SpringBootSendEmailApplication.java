package com.sanjeev;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.sanjeev.service.EmailService;

@SpringBootApplication
public class SpringBootSendEmailApplication {
	
	@Autowired
	private EmailService emailSenderervice;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootSendEmailApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		emailSenderervice.sendMail
		("Sarathiplus@gmail.com","Hello sir, greetings of the day Please find the attached copy of my resume below."
				+ "Regards "
				+ "sanjeev",
				"sanjeev Resume","E:\\sanjeev resume.pdf");

	}

}
