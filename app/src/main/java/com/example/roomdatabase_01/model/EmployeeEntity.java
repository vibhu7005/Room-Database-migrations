package com.example.roomdatabase_01.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Employee-Db")
public class EmployeeEntity {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "emailAddress")
    private String emailAddress;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "mobileNumber")
    private String mobileNumber;

    @ColumnInfo(name = "otherInfo")
    private String other;

    @ColumnInfo(name = "position")
    private String position;


    public EmployeeEntity() {

    }

    public EmployeeEntity(String name, String email, String mobileNo) {
        this.name = name;
        this.emailAddress = email;
        this.mobileNumber = mobileNo;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
