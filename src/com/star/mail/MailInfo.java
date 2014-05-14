package com.star.mail;

import java.util.Properties;

public class MailInfo {

	/**
	 * 发送邮件主机地址
	 */
	private String mailServerHost;
	/**
	 * 发送邮件主机地址端口
	 */
	private String mailServerPort;
	/**
	 * 邮件发送者地址
	 */
	private String fromAddress;
	/**
	 * 邮件接受者地址
	 */
	private String toAddress;
	/**
	 * 邮件发送者用户名
	 */
	private String userName;
	/**
	 * 邮件发送者密码
	 */
	private String password;
	/**
	 * 是否需要身份验证
	 */
	private boolean validate;
	/**
	 * 邮件主题
	 */
	private String subject;
	/**
	 * 发送内容
	 */
	private String content;
	/**
	 * 发送附件名
	 */
	private String[] attachFileNames;
	
	/**
	 * SSL认证类
	 */
	private final static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";

	public Properties getProperties() {
		Properties pro = new Properties();
		pro.put("mail.smtp.host", this.mailServerHost);
		pro.put("mail.smtp.port", this.mailServerPort);
		pro.put("mail.smtp.auth", this.validate ? true : false);
		pro.put("mail.transport.protocol", "smtp");
		pro.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
		return pro;
	}

	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

}
