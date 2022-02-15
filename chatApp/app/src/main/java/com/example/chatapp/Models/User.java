package com.example.chatapp.Models;

public class User {
    private String profilePic,userName,password,mail,userId,lastMessage;

    public User(String profilePic, String userName, String password, String mail, String userId, String lastMessage) {
        this.profilePic = profilePic;
        this.userName = userName;
        this.password = password;
        this.mail = mail;
        this.userId = userId;
        this.lastMessage = lastMessage;
    }
    public User(){

    }

    // Signup Constructor


    public User(String userName, String password, String mail) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
