package com.hackthon.kisainsur.src;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hackthon.kisainsur.R;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    private List<Item> data;

    public ExpandableListAdapter(List<Item> data) {
        this.data = data;
    }

    boolean[] isCheckedItem;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = null;
        Context context = parent.getContext();
        isCheckedItem = new boolean[6];
        float dp = context.getResources().getDisplayMetrics().density;
        switch (type) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.recycler_item, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                LayoutInflater inflater1 = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater1.inflate(R.layout.recycler_item_people, parent, false);
                ListChildViewHolder child = new ListChildViewHolder(view);
                return child;
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Item item = data.get(position);

        switch (item.type) {
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = item;
                itemController.header_title.setText(item.text);
                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.tri_bottom);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.tri_top);
                }
                itemController.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<>();
                            int count = 0;
                            int pos = data.indexOf(itemController.refferalItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.tri_bottom);
                        } else {
                            int pos = data.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.tri_top);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD:
                final ListChildViewHolder listChildViewHolder = (ListChildViewHolder) holder;
                TextView itemTextView = listChildViewHolder.peopleName;
                final ImageView imageView = listChildViewHolder.checkPeople;
                imageView.setImageResource(R.drawable.ic_unchecked);
                itemTextView.setText(data.get(position).text);

                listChildViewHolder.checkPeople.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!item.check) {
                            imageView.setImageResource(R.drawable.ic_checked);
                            item.check = true;
                        }else {
                            imageView.setImageResource(R.drawable.ic_unchecked);
                            item.check = false;
                        }
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView header_title;
        public ImageView btn_expand_toggle;
        public Item refferalItem;

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = itemView.findViewById(R.id.className);
            btn_expand_toggle = itemView.findViewById(R.id.checkClass);
        }
    }

    private static class ListChildViewHolder extends RecyclerView.ViewHolder {
        public TextView peopleName;
        public ImageView checkPeople;

        public ListChildViewHolder(View itemView) {
            super(itemView);
            peopleName = itemView.findViewById(R.id.peopleName);
            checkPeople = itemView.findViewById(R.id.checkPeople);
        }
    }

    public static class Item {
        public int type;
        public String text;
        public boolean check;
        public List<Item> invisibleChildren;

        public Item() {
        }

        public Item(int type, String text, boolean check) {
            this.type = type;
            this.text = text;
            this.check = check;
        }
    }


}
