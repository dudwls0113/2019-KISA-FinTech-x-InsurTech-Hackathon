package com.hackthon.kisainsur.src.guest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.hackthon.kisainsur.R;
import com.hackthon.kisainsur.src.BaseActivity;
import com.hackthon.kisainsur.src.guest.interfaces.GuestActivityView;
import com.hackthon.kisainsur.src.guest.models.Travel;

public class GuestInfoActivity extends BaseActivity implements GuestActivityView {
    String fcmToken;
    int travelNo;

    TextView mTextViewContent, mTextViewStartat, mTextViewLocation, mTextViewPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_info);


        mTextViewContent = findViewById(R.id.activity_guest_info_tv_content);
        mTextViewStartat = findViewById(R.id.activity_guest_info_tv_startAt);
        mTextViewLocation = findViewById(R.id.activity_guest_info_tv_location);
        mTextViewPrice = findViewById(R.id.activity_guest_info_tv_price);

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this,
                new OnSuccessListener<InstanceIdResult>() {
                    @Override
                    public void onSuccess(InstanceIdResult instanceIdResult) {
                        fcmToken = instanceIdResult.getToken();
                        Log.d("Firebase", "token: " + fcmToken);
                    }
                });

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            travelNo = intent.getExtras().getInt("travelNo");
        }
        if (travelNo > 0) {
            getTreval();
        }

    }

    void getTreval() {
        showProgressDialog();
        final GuestService guestService = new GuestService(this);
        guestService.getTreval(travelNo);
    }


    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.activity_guest_info_ok:

                break;

        }
    }

    @Override
    public void getTravelSuccess(Travel travel) {
        hideProgressDialog();

        mTextViewContent.setText(travel.getContent());
        mTextViewStartat.setText(travel.getStartAt());
        mTextViewLocation.setText(travel.getLocation());
        mTextViewPrice.setText(travel.getPrice()+"원");

    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
    }
}
