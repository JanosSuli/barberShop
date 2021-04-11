package com.janosSuli.barberShop.model;

import org.mindrot.jbcrypt.BCrypt;

public class UserModel {

    private int id;
    private String userName;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private boolean isAdmin;

    public UserModel() {
    }

    public UserModel(String userName, String email, String password) {

        this.userName = userName;
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.isAdmin = false;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
