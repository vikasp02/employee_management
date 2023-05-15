package com.example.emplyeemanagementapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIendpoints {

    String url="https://jsonplaceholder.typicode.com/users/";
//    String url="http://192.168.1.101:8081/";

    // Get APi
    @GET("https://jsonplaceholder.typicode.com/users")
    Call<List<EmployeeModel>> getdataEmployee();



}
