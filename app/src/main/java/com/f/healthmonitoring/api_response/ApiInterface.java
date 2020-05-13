package com.f.healthmonitoring.api_response;

import com.f.healthmonitoring.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {


    @FormUrlEncoded
    @POST("loginPatient")
    Call<LoginResponse> login(@Field("phonenumber") String phonenumber, @Field("password") String password);


}
