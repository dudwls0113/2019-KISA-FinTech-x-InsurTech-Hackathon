package com.hackthon.kisainsur.src.guest.interfaces;

import com.hackthon.kisainsur.src.guest.models.Travel;

public interface GuestActivityView {

    void getTravelSuccess(Travel travel);

    void validateFailure(String message);
}
