package com.sms.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailIHMS {

	private String email_to;
	private String email_subject;
	private String email_body;
	public SendMailIHMS(String mailTo,String mailSubject,String mailBody)
	{
		this.email_to=mailTo;
		this.email_body=mailBody;
		this.email_subject=mailSubject;
	}
		
	public void sendEmail()
	{
		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.dsn.notify","FAILURE ORCPT=rfc822;");
		props.put("mail.smtp.dsn.ret", "FULL"); 
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("thedeveloperzone@gmail.com", "9861098610");  
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("no-reply@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email_to));
			
			message.setSubject(email_subject);
			message.setText(email_body);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	

	}

}
