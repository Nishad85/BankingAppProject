package com.lti.service;

import com.lti.entity.EmailDetails;

//Java Program to Illustrate Creation Of
//Service Interface

//Interface
public interface EmailService {

	// Method
	// To send a simple email
	String sendSimpleMail(EmailDetails details);

	// Method
	// To send an email with attachment
	String sendMailWithAttachment(EmailDetails details);
}
