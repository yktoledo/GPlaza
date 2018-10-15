package com.example.yendry.gplaza.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yendry.gplaza.R;
import com.example.yendry.gplaza.domain.model.User;
import com.squareup.picasso.Picasso;

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
    public MyVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH myVH, int position) {
        Picasso.get().load(list.get(position).getAvatar()).into(myVH.avatar);
        myVH.name.setText("Name: "+list.get(position).getFirstName());
        myVH.lastName.setText("Last Name: "+list.get(position).getLastName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView avatar;
        TextView name, lastName;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
            lastName = itemView.findViewById(R.id.last_name);
            avatar = itemView.findViewById(R.id.avatar_id);


        }

        @Override
        public void onClick(View view) {

        }
    }
}
