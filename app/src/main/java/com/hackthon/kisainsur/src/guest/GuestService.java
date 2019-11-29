package com.hackthon.kisainsur.src.guest;

import android.util.Log;

import com.hackthon.kisainsur.src.guest.interfaces.GuestActivityView;
import com.hackthon.kisainsur.src.guest.interfaces.GuestRetrofitInterface;
import com.hackthon.kisainsur.src.guest.models.TravelResponse;
import com.hackthon.kisainsur.src.main.interfaces.MainActivityView;
import com.hackthon.kisainsur.src.main.interfaces.MainRetrofitInterface;
import com.hackthon.kisainsur.src.main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hackthon.kisainsur.src.ApplicationClass.getRetrofit;

class GuestService {
    private final GuestActivityView mGuestActivityView;

    GuestService(final GuestActivityView mGuestActivityView) {
        this.mGuestActivityView = mGuestActivityView;
    }

    void getTreval(int travelNo) {
        final GuestRetrofitInterface guestRetrofitInterface = getRetrofit().create(GuestRetrofitInterface.class);
        guestRetrofitInterface.getTravel(travelNo).enqueue(new Callback<TravelResponse>() {
            @Override
            public void onResponse(Call<TravelResponse> call, Response<TravelResponse> response) {
                final TravelResponse travelResponse = response.body();
                if (travelResponse == null) {
                    mGuestActivityView.validateFailure(null);
                    return;
                } else if (travelResponse.getCode() == 100) {
                    mGuestActivityView.getTravelSuccess(travelResponse.getTravelList());
                }
                Log.d("에라", travelResponse.getMessage());
                mGuestActivityView.validateFailure(travelResponse.getMessage());
            }

            @Override
            public void onFailure(Call<TravelResponse> call, Throwable t) {
                Log.d("에라", t.toString());
                mGuestActivityView.validateFailure(null);
            }
        });
    }
}
