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

    @GET("/test/{number}")
    Call<DefaultResponse> getTestPathAndQuery(
            @Path("number") int number,
            @Query("content") final String content
    );

    @POST("/test")
    Call<DefaultResponse> postTest(@Body RequestBody params);
}