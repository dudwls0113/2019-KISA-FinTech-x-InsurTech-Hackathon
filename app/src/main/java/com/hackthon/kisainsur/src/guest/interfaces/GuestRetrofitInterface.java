package com.hackthon.kisainsur.src.guest.interfaces;


import com.hackthon.kisainsur.src.guest.models.TravelResponse;
import com.hackthon.kisainsur.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GuestRetrofitInterface {
    //    @GET("/test")
    @GET("/travel/{travelNo}")
    Call<TravelResponse> getTravel(@Path("travelNo") int travelNo);

    @GET("/pushTravel/1/1")
    Call<DefaultResponse> pushTravel();

    @GET("/pushInputDone")
    Call<DefaultResponse> pushInputDone();

    @POST("/travel")
    Call<DefaultResponse> postTravel(@Body RequestBody params);
}
