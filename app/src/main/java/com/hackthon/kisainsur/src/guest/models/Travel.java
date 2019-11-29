package com.hackthon.kisainsur.src.guest.models;

import com.google.gson.annotations.SerializedName;

public class Travel {
    @SerializedName("travelNo")
    private int travelNo;

    @SerializedName("content")
    private String content;

    @SerializedName("startAt")
    private String startAt;

    @SerializedName("endAt")
    private String endAt;

    @SerializedName("location")
    private String location;

    @SerializedName("price")
    private int price;

    public int getTravelNo() {
        return travelNo;
    }

    public String getContent() {
        return content;
    }

    public String getStartAt() {
        return startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }
}
