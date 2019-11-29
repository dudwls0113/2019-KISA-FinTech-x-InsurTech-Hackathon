package com.hackthon.kisainsur.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.hackthon.kisainsur.R;
import com.hackthon.kisainsur.src.BaseActivity;
import com.hackthon.kisainsur.src.MakeNoticeActivity;
import com.hackthon.kisainsur.src.PeopleListActivity;
import com.hackthon.kisainsur.src.PhoneNumberActivity;
import com.hackthon.kisainsur.src.main.interfaces.MainActivityView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickBtn(View view){
        switch (view.getId()){
            case R.id.makingNoticeBtn:
                Intent intent = new Intent(MainActivity.this, MakeNoticeActivity.class);
                startActivity(intent);
                break;
            case R.id.studentListBtn:
                Intent intent1 = new Intent(MainActivity.this, PeopleListActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
