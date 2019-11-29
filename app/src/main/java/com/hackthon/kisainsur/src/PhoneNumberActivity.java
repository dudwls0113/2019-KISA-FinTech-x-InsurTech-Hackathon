package com.hackthon.kisainsur.src;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hackthon.kisainsur.R;

import java.util.ArrayList;

public class PhoneNumberActivity extends AppCompatActivity {
    private PhoneNumberAdapter mAdapter;
    RecyclerView mRecyclerView;
    ArrayList<String> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        mArrayList = new ArrayList<>();
        mArrayList.add("3학년 1반");
        mArrayList.add("3학년 2반");
        mArrayList.add("3학년 3반");

        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new PhoneNumberAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);


    }


}
