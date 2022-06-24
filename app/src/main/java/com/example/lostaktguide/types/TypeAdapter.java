package com.example.lostaktguide.types;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lostaktguide.R;
import com.example.lostaktguide.data.ClassItem;

import java.util.ArrayList;
import java.util.List;



public class TypeAdapter
        extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {

    private List<ClassItem> itemList;
    private final View.OnClickListener clickListener;


    public TypeAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }

    public void addItem(ClassItem item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<ClassItem> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<ClassItem> items){
        itemList = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.type_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.contentView.setText(itemList.get(position).content);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.content);
        }
    }
}
