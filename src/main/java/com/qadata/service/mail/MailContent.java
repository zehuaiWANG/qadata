package com.qadata.service.mail;

public class MailContent {
    public String getRegisterContent(String mail,String checkCode){
        return mail+"您好；<br>" +
                "<br>" +
                "感谢您注册 Deusino QA DATA Management System<br>" +
                "您的登录邮箱是:"+mail+"<br>" +
                "您的注册码是:"+ checkCode +"<br>" +
                "请输入注册码完成注册流程<br>" +
                "<br>" +
                "<br>" +
                "我们的工作人员审核通过后，会电邮通知您。<br>" +
                "<br>" +
                "<br>" +
                "Deusino Technical Consulting（SZ）Co.,Ltd<br>" +
                "www.qa-data.com<br>" +
                "<br>" +
                "如果您有任何疑问，请联络我们： E-Mail： service@qa-data.com<br>" +
                "此邮件为系统自动发送，请勿回复。<br>" +
                "-----------------------------------------------------------------------------------------<br> "+
                mail+" hello;           <br>" +
                "<br>" +
                "Thank you for registering Deusino QA DATA Management System           <br>" +
                "Your login mailbox is:"+mail+"<br>" +
                "Your registration code is:"+ checkCode +"<br>" +
                "Please enter the registration code to complete the registration process           <br>" +
                "<br>" +
                "<br>" +
                "Our staff will notify you by email when the audit is approved.           <br>" +
                "<br>" +
                "<br>" +
                "Deusino Technical Consulting（SZ）Co.,Ltd<br>" +
                "www.qa-data.com<br>" +
                "<br>" +
                "If you have any questions, please contact us: E-Mail:service@qa-data.com           <br>" +
                "This message is automatically sent by the system. Please do not reply.<br><br>";
    }

    public String getResetPassContent(String name,String checkCode){
        return name+" 您好；<br>" +
                "<br>" +
                "尊敬的客户，您请求的验证码是："+checkCode+"<br>" +
                "此验证码十分钟内有效，如非本人操作，请忽略此邮件。<br>" +
                "<br>" +
                "<br>" +
                "Deusino Technical Consulting（SZ）Co.,Ltd<br>" +
                "www.qa-data.com<br>" +
                "<br>" +
                "如果您有任何疑问，请联络我们： E-Mail： service@qa-data.com<br>" +
                "此邮件为系统自动发送，请勿回复。<br>" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br><br>" +
                " Hello "+name+";<br>" +
                "<br>" +
                "you of the registration verification code is "+checkCode+"<br>" +
                "The verification code in 10 minutes.If not the operation, please ignore this email.<br>" +
                "<br><br>" +
                 "<br>" +
                "Deusino Technical Consulting（SZ）Co.,Ltd<br>" +
                "www.qa-data.com<br>" +
                "<br>" +
                "If you have any questions, please contact us: E-Mail: serviceqa-data. com<br>" +
                "As the system automatically sends this message, please do not reply.<br>" +
                "<br>";
    }
}
