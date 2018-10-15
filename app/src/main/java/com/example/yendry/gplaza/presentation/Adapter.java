package com.example.yendry.gplaza.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yendry.gplaza.R;
import com.example.yendry.gplaza.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyVH> {

    List<User> list = new ArrayList<>();

    public void setList(List<User> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public void addUser(User user){
        list.add(user);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH myVH, int i) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        public MyVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
