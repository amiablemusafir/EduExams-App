package com.oes.action.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	private String email_to;
	private String email_subject;
	private String email_body;
	public SendMailTLS(String mailTo,String mailSubject,String mailBody)
	{
		this.email_to=mailTo;
		this.email_body=mailBody;
		this.email_subject=mailSubject;
	}
		
	public void sendEmail()
	{
		
		String host="mail.xamdesk.com";  
		final String user="accounts@xamdesk.com";//change accordingly  
		final String password="23-jaisunnydev";//change accordingly 
		
		Properties props = new Properties();
		props.put("mail.smtp.host",host);  
		props.put("mail.smtp.auth", "true");  
		
		/*props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.dsn.notify","FAILURE ORCPT=rfc822;");
		props.put("mail.smtp.dsn.ret", "FULL"); 
		props.put("mail.smtp.host", "mail.xamdesk.com");
		*/
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(user,password);  
			} 
		});
		
		//Compose the message  
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("accounts@xamdesk.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email_to));
				
			message.setSubject(email_subject);
			message.setText(email_body);		

			message.setContent(email_body, "text/html");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	

	}

}
