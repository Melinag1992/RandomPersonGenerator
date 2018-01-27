package com.example.c4q.exam.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.exam.R;
import com.example.c4q.exam.model.Results;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 1/24/18.
 */

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

    private List<Results> resultsList;
    private Context context;
    private String picURL;
    private Results results;

    public ModelAdapter(Context context) {
        resultsList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_itemview, parent, false);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ModelViewHolder holder, final int position) {

        holder.lastName.setText(resultsList.get(position).getName().getLast());
        holder.firstName.setText(resultsList.get(position).getName().getFirst());
        picURL = resultsList.get(position).getPicture().getMedium();

        Picasso.with(context).load(picURL)
                .resize(400, 400)
                .centerCrop()
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonalDetail.class);


                results = resultsList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("result", results);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    } public void addImages(List<Results> rootObject) {
        resultsList.clear();
        resultsList.addAll(rootObject);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }



    public class ModelViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView firstName;
        private TextView lastName;

        public ModelViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            firstName = (TextView) itemView.findViewById(R.id.firstname);
            lastName = (TextView) itemView.findViewById(R.id.lastname);

        }
    }
}
