package com.star.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{

	private String userName = null;
	private String password = null;
	
	public MyAuthenticator() {
		// TODO Auto-generated constructor stub
	}
	
	public MyAuthenticator(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.userName, this.password);
	}
	
}
