package com.example.emplyeemanagementapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController
{

    private static ApiController clientobject =null;
    private static Retrofit retrofit;
    private APIendpoints myApi;

    ApiController()
    {

        retrofit=new Retrofit.Builder()
                .baseUrl(APIendpoints.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(APIendpoints.class);

    }

    public static synchronized ApiController getInstance()
    {
        if(clientobject==null) {
            clientobject = new ApiController();
        }
        return clientobject;
    }

//    ApiSet getapi()
//    {
//        return retrofit.create(ApiSet.class);
//    }

    public APIendpoints getApiSet() {
        return myApi;
    }
}
