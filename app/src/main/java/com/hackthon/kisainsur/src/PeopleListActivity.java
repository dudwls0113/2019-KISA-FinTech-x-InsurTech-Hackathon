package com.hackthon.kisainsur.src;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.hackthon.kisainsur.R;
import com.hackthon.kisainsur.src.main.interfaces.MainRetrofitInterface;
import com.hackthon.kisainsur.src.main.models.DefaultResponse;
import com.hackthon.kisainsur.src.main.models.StudentResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hackthon.kisainsur.src.ApplicationClass.getRetrofit;

public class PeopleListActivity extends AppCompatActivity {
    ArrayList<StudentResponse.Student> mArrayList;
    RecyclerView mRecyclerView;
    PeopleListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        mRecyclerView = findViewById(R.id.listRecyclerView);
        mArrayList = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void onStart() {
        super.onStart();
        getStudent();
    }

    void getStudent() {
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getStudents().enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {
                final StudentResponse studentResponse = response.body();
                if (studentResponse == null) {
                    Log.d("결과", "ㅇ");
                    return;
                }

                mAdapter = new PeopleListAdapter(studentResponse.getStudents());
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {

                Log.d("결과", t+"");
            }
        });
    }

}
