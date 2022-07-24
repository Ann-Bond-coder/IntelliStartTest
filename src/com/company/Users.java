package com.company;

public class Users {
    private int userId;
    private String userName;
    private String userLastName;
    private double userAmountOfMoney;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public double getUserAmountOfMoney() {
        return userAmountOfMoney;
    }

    public void setUserAmountOfMoney(double userAmountOfMoney) {
        this.userAmountOfMoney = userAmountOfMoney;
    }

    public Users(int userId, String userName, String userLastName, double userAmountOfMoney) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userAmountOfMoney = userAmountOfMoney;
    }

    @Override
    public String toString() {
        return "\nUser № " + this.userId + "; Name: " +  this.userName + "; Last name: " + this.userLastName +
                "; Amount of money: " + this.userAmountOfMoney;
    }
}
