package com.qadata.pojo;

public class User {
    private Integer id;

    private String type;

    private String name;

    private String password;

    private String phonenumber;

    private String receiveMail;

    private String state;

    private String mail;

    public User(Integer id, String type, String name, String password, String phonenumber, String receiveMail, String state, String mail) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.password = password;
        this.phonenumber = phonenumber;
        this.receiveMail = receiveMail;
        this.state = state;
        this.mail = mail;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getReceiveMail() {
        return receiveMail;
    }

    public void setReceiveMail(String receiveMail) {
        this.receiveMail = receiveMail == null ? null : receiveMail.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }
}