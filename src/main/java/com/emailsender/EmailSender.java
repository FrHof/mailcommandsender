package com.emailsender;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
public class EmailSender {
	String from;
	String passw;
	String to;
	String host;
	String port;
	public EmailSender(String from, String passw, String to, String host, String port) {
		this.from = from;
		this.passw = passw;
		this.to = to;
		this.host = host;
		this.port = port;
	}
	/**
	 * Return from mail from the object
	 * @return from field
	 */
	private String getFrom() {
		return this.from;
	}
	/**
	 * Return passw from the object
	 * @return passw field
	 */
	private String getPassw() {
		return this.passw;
	}
	/**
	 * Init a smtp session with informations of fields of the EmailSender Object
	 * @return a Session Object
	 */
	public Session initSession() {
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", this.host);
		props.put("mail.smtp.port",this.port);
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); 
		props.put("mail.smtp.ssl.trust", this.host);
		System.out.println("Start Authenticate...");
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				String from = getFrom();
				String pass = getPassw();
				return new PasswordAuthentication(from, pass);
			}
		};
		System.out.println("Start Creating Session...");
		return Session.getInstance(props, auth); 
		
	}
	/**
	 * Send and email with the session object specified in parameters
	 * @param session
	 */
	public void sendEmail(Session session, String subject, String content) {
		try{  
	         MimeMessage message = new MimeMessage(session);  
	         message.setFrom(new InternetAddress(this.from));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(this.to));  
	         message.setSubject(subject);  
	         message.setText(content);  
	  
	         // Send message  
	         Transport.send(message);  
	         System.out.println("message sent successfully....");  
	  
	      }catch (MessagingException mex) {mex.printStackTrace();} 
	}
}
