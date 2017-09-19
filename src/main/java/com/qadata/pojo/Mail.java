package com.qadata.pojo;

public class Mail {
    private String mailContent;

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent == null ? null : mailContent.trim();
    }
}