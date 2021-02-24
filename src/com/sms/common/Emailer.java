package com.sms.common;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;



public final class Emailer {

	private static Properties mailServerConfig = null;
	private static String mailConfigPath = "MailServerConfiguration.properties";
	
	static{
		mailServerConfig = readMailServerConfig(mailConfigPath);
	}
	public void sendEmail(String emailTo,String subject,String text)
	{
		// Setup mail server
		String from = mailServerConfig.getProperty("mail.from");
		String to = emailTo;
		String subjectbody =subject;
		String textBody=text;
		//String host = mailServerConfig.getProperty("mail.host");
		/*Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", "true");*/
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props,auth);


		MimeMessage message = new MimeMessage( session );
		try {
			// Create a default MimeMessage object.

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.setRecipient(RecipientType.TO,	new InternetAddress(to));
			// Set Subject: header field
			message.setSubject(subjectbody);
			// Now set the actual message
			//message.setText(textBody);
			message.setContent(textBody, "text/html");
			
			// Send message
			Transport.send(message);
			//System.out.println("Sent message successfully....");
			}
		catch (MessagingException ex){
			System.err.println("Cannot send email. " + ex);
		}
	}

/* read mail server congiguration properties file */ 
    
    private static Properties readMailServerConfig(String file)
    {

    	Properties prop = new Properties();
    	InputStream inputStream = null;
    	try {
    		inputStream = Emailer.class.getClassLoader().getResourceAsStream(file);  
    		prop.load(inputStream);

    	} catch (IOException e) {
    		e.printStackTrace();
    	}finally{
    		if (inputStream != null){
    			try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}

    	return prop;
    }  
   
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{

		public PasswordAuthentication getPasswordAuthentication()
		{
			String username = mailServerConfig.getProperty("mail.smtp.auth.user");
			String password =  mailServerConfig.getProperty("mail.smtp.auth.password");
			return new PasswordAuthentication(username, password);
		}
	}
	
	public void sendEmailWithAttachment(String emailTo,String subject,String text,String filename)
	{
		// Setup mail server
		String from = mailServerConfig.getProperty("mail.from");
		String to = emailTo;
		String subjectbody =subject;
		String textBody=text;
		//String host = mailServerConfig.getProperty("mail.host");
		/*Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", "true");*/
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props,auth);


		MimeMessage message = new MimeMessage( session );
		try {
			// Create a default MimeMessage object.

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.setRecipient(RecipientType.TO,	new InternetAddress(to));
			// Set Subject: header field
			message.setSubject(subjectbody);
			// Now set the actual message
			//message.setText(textBody);
			MimeBodyPart mbp1 = new MimeBodyPart();
		    mbp1.setText(text);

		      // create the second message part
		    MimeBodyPart mbp2 = new MimeBodyPart();

		            // attach the file to the message
		     FileDataSource fds = new FileDataSource(filename){
	                @Override
	                
	                public String getContentType() {
	                	
	                    return "application/octet-stream";
	                }
	            };
		     mbp2.setDataHandler(new DataHandler(fds));
		     mbp2.setFileName(fds.getName());

		      // create the Multipart and add its parts to it
		      Multipart mp = new MimeMultipart();
		      mp.addBodyPart(mbp1);
		      mp.addBodyPart(mbp2);

		      // add the Multipart to the message
		      message.setContent(mp);
			//message.setContent(textBody, "text/html");
			// Send message
			Transport.send(message);
			//System.out.println("Sent message successfully...."); 
			}
		catch (MessagingException ex){
			System.err.println("Cannot send email. " + ex);
		}
	}
	
} 