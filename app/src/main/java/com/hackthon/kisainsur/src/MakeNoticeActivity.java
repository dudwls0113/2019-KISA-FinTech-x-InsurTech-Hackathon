package com.hackthon.kisainsur.src;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.hackthon.kisainsur.R;
import com.hackthon.kisainsur.src.guest.GuestInputActivity;
import com.hackthon.kisainsur.src.guest.interfaces.GuestRetrofitInterface;
import com.hackthon.kisainsur.src.main.models.DefaultResponse;
import com.hackthon.kisainsur.src.phone_number.PhoneNumberActivity;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hackthon.kisainsur.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.hackthon.kisainsur.src.ApplicationClass.getRetrofit;

public class MakeNoticeActivity extends BaseActivity {
    TextView mDateEdit;
    EditText mEditTextLocation, mTextViewPrice, mTextViewContent;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_notice);
        mContext = this;

        mDateEdit = findViewById(R.id.activity_make_notice_tv_date);
        mEditTextLocation = findViewById(R.id.activity_make_notice_et_location);
        mTextViewPrice = findViewById(R.id.activity_make_notice_et_price);
        mTextViewContent = findViewById(R.id.activity_make_notice_et_content);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_make_notice_tv_date:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MakeNoticeActivity.this, listener, 2019, 11, 29);
                    datePickerDialog.show();
                }
                break;
            case R.id.finishMakingNotice:
                try {
                    postTravel();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
        }
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mDateEdit.setText((year) + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일");
        }
    };

    void postTravel() throws JSONException {
        JSONObject params = new JSONObject();
        params.put("content", mTextViewContent.getText().toString());
        params.put("startAt", mDateEdit.getText().toString());
        params.put("endAt", mDateEdit.getText().toString());
        params.put("location", mEditTextLocation.getText().toString());
        params.put("price", Integer.parseInt(mTextViewPrice.getText().toString()));

        final GuestRetrofitInterface guestRetrofitInterface = getRetrofit().create(GuestRetrofitInterface.class);
        guestRetrofitInterface.postTravel(RequestBody.create(params.toString(), MEDIA_TYPE_JSON)).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                } else if (defaultResponse.getCode() == 100) {
                    Intent intent = new Intent(mContext, PhoneNumberActivity.class);
                    startActivity(intent);
                } else {
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
            }
        });
    }


}
