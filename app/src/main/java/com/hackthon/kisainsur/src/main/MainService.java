package com.hackthon.kisainsur.src.main;

import com.hackthon.kisainsur.src.main.interfaces.MainActivityView;
import com.hackthon.kisainsur.src.main.interfaces.MainRetrofitInterface;
import com.hackthon.kisainsur.src.main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hackthon.kisainsur.src.ApplicationClass.getRetrofit;

class MainService {
    private final MainActivityView mMainActivityView;

    MainService(final MainActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

//        void getTest() {
//            final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
//            mainRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
//                @Override
//                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
//                    final DefaultResponse defaultResponse = response.body();
//                    if (defaultResponse == null) {
//                        mMainActivityView.validateFailure(null);
//                        return;
//                    }
//
//                    mMainActivityView.validateSuccess(defaultResponse.getMessage());
//                }
//
//                @Override
//                public void onFailure(Call<DefaultResponse> call, Throwable t) {
//                    mMainActivityView.validateFailure(null);
//                }
//            });
//        }
}
