package com.hackthon.kisainsur.src;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hackthon.kisainsur.R;
import com.hackthon.kisainsur.src.main.MainActivity;

import java.util.ArrayList;

public class PhoneNumberActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ArrayList<ExpandableListAdapter.Item> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mData = new ArrayList<>();

        mData.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "3학년 1반", false, null));
        mData.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "펭수", false, "01022223333"));
        mData.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "도리", false, "01011113333"));
        mData.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "문", false, "01044445555"));
        mData.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "소냐", false, "01099998888"));
        mData.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "소요", false, "01055554444"));
        mData.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "제리", false, "01089898111"));
        mData.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "3학년 2반", false, null));

        ExpandableListAdapter.Item places = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "3학년 3반", false, null);

        mData.add(places);

        mRecyclerView.setAdapter(new ExpandableListAdapter(mData));
    }


    public void onClickBtn(View view){
        switch (view.getId()){
            case R.id.giveNoticeBtn:
                for (int i = 0;i<mData.size();i++){
                    if(mData.get(i).check){

                    }
                }
                Intent intent = new Intent(PhoneNumberActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }

    }


}
