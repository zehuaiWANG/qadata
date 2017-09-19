
package com.qadata.service.mail;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailClientService")
public class MailClientService {

	/** 是否发送告警邮件 0 不发送 1发送 **/
	@Value("${isSendMail:0}")
	public String isSendMail = "1";

	@Async
	public void sendMail(String title, String content, String receiver) {
		if (isSendMail.equals("0")) {
			return;
		}
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.ym.163.com");
		mailInfo.setMailServerPort("994");
		mailInfo.setValidate(true);
		mailInfo.setUserName("info@qa-data.com");
		mailInfo.setPassword("111111");// 您的邮箱密码
		mailInfo.setFromAddress("info@qa-data.com");
		//邮件太多，暂时屏蔽
		mailInfo.setToAddress(receiver);
		mailInfo.setSubject(title);
		mailInfo.setContent(content);
		SimpleMailSender sms = new SimpleMailSender();
		// sms.sendTextMail(mailInfo);// 发送文体格式
		sms.sendHtmlMail(mailInfo);// 发送html格式
	}
	public void sendRegisterMail(String receiver,String registerCode){
		MailContent mailContent =new MailContent();
		sendMail("deusino verification code徳商验证码", mailContent.getRegisterContent(receiver,registerCode),receiver);
	}
	public void sendResetPassMail(String receiver,String checkCode,String username){
		MailContent mailContent =new MailContent();
		sendMail("deusino verification code徳商验证码", mailContent.getResetPassContent(username,checkCode),receiver);
	}
}
