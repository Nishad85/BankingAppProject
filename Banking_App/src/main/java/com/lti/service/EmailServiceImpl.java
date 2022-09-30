package com.lti.service;

//Java Program to Illustrate Creation Of
//Service implementation class


import java.io.File;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerRepository;
import com.lti.dao.UserRepository;
import com.lti.entity.Customer;
import com.lti.entity.EmailDetails;
import com.lti.entity.User;

//Annotation
@Service
//Class
//Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

	@Autowired private JavaMailSender javaMailSender;

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private CustomerRepository crepo;
	
	
	@Value("${spring.mail.username}") private String sender;

	// Method 1
	// To send a simple email
	public String sendSimpleMail(EmailDetails details)
	{
	    
		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage
				= new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText("Thank you for opening an account with Aspire Bank. We will be your boat for you to have a safe voyage.\n"
					+ "Your User Id :"+ details.getUsername()+" and password :"+details.getPassword());
			mailMessage.setSubject(" Login Details for NetBanking ");

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

	// Method 2
	// To send an email with attachment
	public String
	sendMailWithAttachment(EmailDetails details)
	{
		// Creating a mime message
		MimeMessage mimeMessage
			= javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper
				= new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(
				details.getSubject());

			// Adding the attachment
			FileSystemResource file
				= new FileSystemResource(
					new File(details.getAttachment()));

			mimeMessageHelper.addAttachment(
				file.getFilename(), file);

			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (MessagingException e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	
}
