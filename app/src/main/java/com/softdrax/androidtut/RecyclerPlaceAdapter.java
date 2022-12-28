package com.softdrax.androidtut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerPlaceAdapter extends RecyclerView.Adapter<RecyclerPlaceAdapter.ViewHolder> {

    Context context;
    ArrayList<PlaceModel> arrPlaceModel;
    RecyclerPlaceAdapter(Context context, ArrayList<PlaceModel> arrPlaceModel){
        this.context=context;
        this.arrPlaceModel=arrPlaceModel;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=  LayoutInflater.from(context).inflate(R.layout.places_row,parent,false);
      ViewHolder viewHolder=new ViewHolder(view);
      return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivPlace.setImageResource(arrPlaceModel.get(position).imgPlace);
        holder.tvPlace.setText(arrPlaceModel.get(position).placeName);
        holder.tvDesc.setText(arrPlaceModel.get(position).placeDesc);

    }

    @Override
    public int getItemCount() {
        return arrPlaceModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

            TextView tvPlace,tvDesc;
            ImageView ivPlace;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPlace=itemView.findViewById(R.id.tvPlace);
            tvDesc=itemView.findViewById(R.id.tvPlaceDesc);
            ivPlace=itemView.findViewById(R.id.ivPlace);
        }
    }
}
