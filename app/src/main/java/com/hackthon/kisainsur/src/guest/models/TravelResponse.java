package com.hackthon.kisainsur.src.guest.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TravelResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<Travel> TravelList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public Travel getTravelList() {
        return TravelList.get(0);
    }
}