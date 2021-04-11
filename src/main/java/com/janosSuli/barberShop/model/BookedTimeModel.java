package com.janosSuli.barberShop.model;

public class BookedTimeModel {

    private int id;
    private int userId;
    private String userFullName;
    private String userEmail;
    private String userPhoneNumber;
    private String barber;
    private String bookedDate;
    private String bookedTime;

    public BookedTimeModel() {
    }

    public BookedTimeModel(int userId, String barber, String bookedDate, String bookedTime) {

        this.userId = userId;
        this.barber = barber;
        this.bookedDate = bookedDate;
        this.bookedTime = bookedTime;

    }

    public BookedTimeModel(String userFullName, String userEmail, String userPhoneNumber, String barber, String bookedDate, String bookedTime) {

        this.userId = userId;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.barber = barber;
        this.bookedDate = bookedDate;
        this.bookedTime = bookedTime;

    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarber() {
        return barber;
    }

    public void setBarber(String barber) {
        this.barber = barber;
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(String bookedDate) {
        this.bookedDate = bookedDate;
    }

    public String getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(String bookedTime) {
        this.bookedTime = bookedTime;
    }

}
