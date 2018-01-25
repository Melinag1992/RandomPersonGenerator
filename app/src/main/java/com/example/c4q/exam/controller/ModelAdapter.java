package com.example.c4q.exam.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.c4q.exam.R;
import com.example.c4q.exam.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 1/24/18.
 */

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

    List<User> userList = new ArrayList<>();

    public ModelAdapter (List<User> userList){
        this.userList = userList;

    }

    @Override
    public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_itemview, parent, false);
        return new ModelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ModelViewHolder holder, int position) {
        holder.onBind(userList.get(position));


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
    class ModelViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView textView2;
        View view;



        public ModelViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text_text);
            this.view = itemView;
        }

        public void onBind(User user) {

        }
    }
}
