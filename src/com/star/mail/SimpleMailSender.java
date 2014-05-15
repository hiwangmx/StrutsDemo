package com.star.mail;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SimpleMailSender {

	private Logger logger = Logger.getLogger(SimpleMailSender.class.toString());
	
	/**
	 * 普通文本方式发送邮件
	 * @param mailInfo
	 * @return
	 */
	public boolean sendTextMail(MailInfo mailInfo){
		MyAuthenticator authenticator = null;
		try {
			logger.info("开始发送本文邮件");
			Properties pro = mailInfo.getProperties();
			if(mailInfo.isValidate()){
				authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
			}
			Session session = Session.getDefaultInstance(pro, authenticator);
			Message mailMessage = new MimeMessage(session);
			Address from = new InternetAddress(mailInfo.getFromAddress());
			mailMessage.setFrom(from);
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(RecipientType.TO, to);
			mailMessage.setSubject(mailInfo.getSubject());
			mailMessage.setSentDate(new Date());
			mailMessage.setText(mailInfo.getContent());
			Transport.send(mailMessage);
			logger.info("结束发本文邮件");
			return true;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 以HTML的方式发送mail
	 * @param mailInfo
	 * @return
	 */
	public boolean sendHtmlMail(MailInfo mailInfo){
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if(mailInfo.isValidate()){
			authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		
		try {
			logger.info("开始发送html邮件");
			Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
			Message message = new MimeMessage(sendMailSession);
			Address from = new InternetAddress(mailInfo.getFromAddress());
			message.setFrom(from);
			Address to = new InternetAddress(mailInfo.getToAddress());
			message.setRecipient(Message.RecipientType.TO, to);
			message.setSubject(mailInfo.getSubject());
			message.setSentDate(new Date());
			
			Multipart multiPart = new MimeMultipart();
			BodyPart html = new MimeBodyPart();
			html.setContent(mailInfo.getContent(), "text/html;charset=utf-8");
			multiPart.addBodyPart(html);
			
			/**
			 * 添加附件
			 */
			if(mailInfo.getAttachFileNames() != null && mailInfo.getAttachFileNames().length > 0){
				for(String fileName : mailInfo.getAttachFileNames()){
					BodyPart attachFile = new MimeBodyPart();
					DataSource dataSource = new FileDataSource(fileName);
					attachFile.setDataHandler(new DataHandler(dataSource));
					attachFile.setFileName(fileName);
					multiPart.addBodyPart(attachFile);
				}
			}
			
			message.setContent(multiPart);
			Transport.send(message);
			logger.info("结束发送html邮件");
			return true;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 异步发送邮件
	 * @param mailInfo
	 */
	public void sendMailByAsynchronous(final MailInfo mailInfo){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					sendHtmlMail(mailInfo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
}
