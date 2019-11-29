package com.hackthon.kisainsur.src;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackthon.kisainsur.R;

import java.util.ArrayList;

public class PhoneNumberAdapter extends RecyclerView.Adapter<PhoneNumberAdapter.ViewHolder> {
    ArrayList<String> mArrayList;
//    PhoneNumberInterface mPhoneNumberInterface;
//    String mClassName;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public PhoneNumberAdapter(ArrayList<String> arrayList) {
//        mPhoneNumberInterface = phoneNumberInterface;
        mArrayList = new ArrayList<>();
        mArrayList = arrayList;
    }

    @NonNull
    @Override
    public PhoneNumberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        PhoneNumberAdapter.ViewHolder vh = new PhoneNumberAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneNumberAdapter.ViewHolder holder, int position) {
        holder.onBind(mArrayList.get(position));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mPhoneNumberInterface.checkPeopleNumber();

            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView classNameText;
        ImageView clickBtn;

        ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            classNameText = itemView.findViewById(R.id.className);
            clickBtn = itemView.findViewById(R.id.checkClass);
        }

        void onBind(String string){
            classNameText.setText(string+"");
        }

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}
