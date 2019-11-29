package com.hackthon.kisainsur.src.main.interfaces;

import com.hackthon.kisainsur.src.main.models.StudentResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MainRetrofitInterface {
//    @GET("/test")
    @GET("/student")
    Call<StudentResponse> getStudents();

}
