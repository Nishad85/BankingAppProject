package com.lti.controller;

//Java Program to Create Rest Controller that
//Defines various API for Sending Mail


//Importing required classes
import com.lti.entity.EmailDetails;
import com.lti.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Annotation
@CrossOrigin(origins="http://localhost:4200")
@RestController
//Class
public class EmailController {

	@Autowired private EmailService emailService;

	// Sending a simple Email
	@PostMapping("/sendMail/{userid}")
	public String sendMail(EmailDetails details)
	{
		String status
			= emailService.sendSimpleMail(details);

		return status;
	}

	// Sending email with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(
		@RequestBody EmailDetails details)
	{
		String status
			= emailService.sendMailWithAttachment(details);

		return status;
	}
}
