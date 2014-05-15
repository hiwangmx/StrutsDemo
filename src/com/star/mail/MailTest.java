package com.star.mail;

public class MailTest {

	public static void main(String[] args) {
		   //这个类主要是设置邮件   
	      MailInfo mailInfo = new MailInfo();    
	      mailInfo.setMailServerHost("smtp.qq.com");    
	      mailInfo.setMailServerPort("465");    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName("593415494@qq.com");    
	      mailInfo.setPassword("333");//您的邮箱密码    
	      mailInfo.setFromAddress("593415494@qq.com");    
	      mailInfo.setToAddress("553613627@qq.com");    
	      mailInfo.setSubject("哈哈");    
	      mailInfo.setContent("哈哈"); 
	      mailInfo.setAttachFileNames(new String[]{"D://8uftp.xml"});
	     
	      //这个类主要来发送邮件   
	      SimpleMailSender sms = new SimpleMailSender();   
	      sms.sendTextMail(mailInfo);//发送文体格式    
	      sms.sendHtmlMail(mailInfo);//发送html格式   
	      
	}
	
}
