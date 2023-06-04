package com.example.newsappjava.network;

import com.example.newsappjava.model.ResponseLogin;
import com.example.newsappjava.model.ResponseNews;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("pemantik/unwapi/login.php")
    Call<ResponseLogin> login(@Field("username") String username,
                              @Field("password") String pass);

    @GET("pemantik/unwapi/getNews.php")
    Call<ResponseNews> news();
}
