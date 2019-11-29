package com.hackthon.kisainsur.src.guest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hackthon.kisainsur.R;
import com.hackthon.kisainsur.src.BaseActivity;
import com.hackthon.kisainsur.src.guest.interfaces.GuestActivityView;
import com.hackthon.kisainsur.src.guest.models.Travel;

public class GuestInputActivity extends BaseActivity implements GuestActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_input_);
    }

    void getTreval() {
        showProgressDialog();
        final GuestService guestService = new GuestService(this);
        guestService.pushTravel();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.activity_guest_tv_send:
                getTreval();
                break;
        }
    }

    @Override
    public void getTravelSuccess(Travel travel) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
