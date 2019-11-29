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
import com.hackthon.kisainsur.src.main.models.StudentResponse;

import java.util.ArrayList;

public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListAdapter.ViewHolder> {
    ArrayList<StudentResponse.Student> mArrayList;


    public PeopleListAdapter(ArrayList<StudentResponse.Student> students){
        mArrayList = new ArrayList<>();
        mArrayList.addAll(students);
    }

    @NonNull
    @Override
    public PeopleListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_item_people_list, parent, false);
        PeopleListAdapter.ViewHolder holder =new PeopleListAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleListAdapter.ViewHolder holder, int position) {
        holder.onBind(mArrayList.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        ImageView checkInfo, checkMoney;
        ViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.peopleListName);
            checkInfo = itemView.findViewById(R.id.checkInfo);
            checkMoney = itemView.findViewById(R.id.checkMoney);
        }

        void onBind(StudentResponse.Student student){
            nameText.setText(student.getName());
            if(student.getIsInsure().equals("0")){
                checkInfo.setImageResource(R.drawable.ic_unchecked);
            }else{
                checkInfo.setImageResource(R.drawable.ic_checked);
            }
            if(student.getIsPay().equals("0")){
                checkMoney.setImageResource(R.drawable.ic_unchecked);
            }else{
                checkMoney.setImageResource(R.drawable.ic_checked);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}
