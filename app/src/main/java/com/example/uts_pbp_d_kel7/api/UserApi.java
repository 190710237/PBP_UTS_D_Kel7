package com.example.uts_pbp_d_kel7.api;
public class UserApi {
    //TODO : insert hosting link here
    public static final String BASE_URL = "http://127.0.0.1:8000/api/";

    public static final String REGISTER = BASE_URL + "register"; //method : POST
    public static final String LOGIN = BASE_URL + "login"; //method : POST
    public static final String VERIFY = BASE_URL + "verify/"; //method : PUT
    public static final String UPDATE_USER = BASE_URL + "update/"; //method : PUT
}
