package com.example.week6practical;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    TextView list_id, list_name, list_description, list_followed;

    public ListViewHolder(View view) {
        super(view);

        list_id = view.findViewById(R.id.tv_id);
        list_name = view.findViewById(R.id.tv_user);
        list_description = view.findViewById(R.id.tv_description);
        list_followed = view.findViewById(R.id.tv_followed);


    }
}
