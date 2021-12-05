package com.example.uts_pbp_d_kel7.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    //TODO : Convert to volley, remove room db
//    @PrimaryKey(autoGenerate = true)
    private int id;
//    @ColumnInfo(name = "username")
    private String username;
//    @ColumnInfo(name = "password")
    private String password;
//    @ColumnInfo(name = "firstname")
    private String firstname;
//    @ColumnInfo(name = "lastname")
    private String lastname;
//    @ColumnInfo(name = "email")
    private String email;
//    @ColumnInfo(name = "birthdate")
    private String birthdate;
//    @ColumnInfo(name = "schoolname")
    private String schoolname;
//    @ColumnInfo(name = "address")
    private String address;
    private String photo;

    //Constructor buat register
    public User(String username, String password, String firstname, String lastname, String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, String firstname, String lastname, String email, String birthdate, String schoolname, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.schoolname = schoolname;
        this.address = address;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
