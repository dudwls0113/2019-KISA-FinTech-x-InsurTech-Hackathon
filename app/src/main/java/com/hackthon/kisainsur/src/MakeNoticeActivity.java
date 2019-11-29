package com.hackthon.kisainsur.src;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.hackthon.kisainsur.R;

public class MakeNoticeActivity extends BaseActivity {
    TextView mDateEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_notice);

        mDateEdit = findViewById(R.id.dateEdit);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.dateEdit:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MakeNoticeActivity.this, listener, 2019, 11, 29);
                    datePickerDialog.show();
                }
        }
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mDateEdit.setText((year+1)+"년 "+ monthOfYear+"월 "+dayOfMonth+"일");
        }
    };

}
