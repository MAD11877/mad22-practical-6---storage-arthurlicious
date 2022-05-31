package com.example.week6practical;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder>{

    ArrayList<User> user;


    public ListAdapter(ArrayList<User> user) {
        this.user = user;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, null, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        User content = user.get(position);
        holder.list_id.setText(String.valueOf(content.id));
        holder.list_name.setText(content.username);
        holder.list_description.setText(content.description);
        holder.list_followed.setText(String.valueOf(content.followed));

    }

    @Override
    public int getItemCount() {
        return user.size();
    }
}
