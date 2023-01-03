package com.softdrax.androidtut;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerPlaceAdapter extends RecyclerView.Adapter<RecyclerPlaceAdapter.ViewHolder> {

    Context context;
    ArrayList<PlaceModel> arrPlaceModel;

    RecyclerPlaceAdapter(Context context, ArrayList<PlaceModel> arrPlaceModel) {
        this.context = context;
        this.arrPlaceModel = arrPlaceModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.places_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.ivPlace.setImageResource(arrPlaceModel.get(position).imgPlace);
        holder.tvPlace.setText(arrPlaceModel.get(position).placeName);
        holder.tvDesc.setText(arrPlaceModel.get(position).placeDesc);
        holder.cvPlaceLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update);


                TextView tvAddUpdateTitle;
                EditText etEditAddPlace, etEditAddLocation, etEditAddDesc;
                Button btnAddUpdate;

                etEditAddPlace = dialog.findViewById(R.id.etEditAddPlace);
                etEditAddLocation = dialog.findViewById(R.id.etEditAddLocation);
                etEditAddDesc = dialog.findViewById(R.id.etEditAddDesc);
                btnAddUpdate = dialog.findViewById(R.id.btnAddUpdate);
                tvAddUpdateTitle = dialog.findViewById(R.id.tvEditAdd);

                tvAddUpdateTitle.setText("Update places");
                btnAddUpdate.setText("Update");

                etEditAddPlace.setText(arrPlaceModel.get(position).placeName);
                etEditAddDesc.setText(arrPlaceModel.get(position).placeDesc);
                etEditAddLocation.setText(arrPlaceModel.get(position).placeLocation);


                btnAddUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String placeName="",placeLocation="",placeDesc="";

                        if (!etEditAddPlace.getText().toString().equals("")) {

                            placeName = etEditAddPlace.getText().toString();
                        }else {
                            Toast.makeText(context, "Add place name", Toast.LENGTH_SHORT).show();
                        }
                        if (!etEditAddLocation.getText().toString().equals("")) {
                            placeLocation = etEditAddLocation.getText().toString();

                        }else {
                            Toast.makeText(context, "Add location", Toast.LENGTH_SHORT).show();
                        }
                        if (!etEditAddDesc.getText().toString().equals("")) {
                            placeDesc = etEditAddDesc.getText().toString();

                        } else {
                            Toast.makeText(context, "Add Description", Toast.LENGTH_SHORT).show();
                        }

                        if(!(placeName.equals("")||placeLocation.equals(""))){
                            arrPlaceModel.set(position,new PlaceModel(R.drawable.ic_launcher_background,placeName,placeDesc,placeLocation));
                            notifyItemChanged(position);

                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });

        holder.cvPlaceLink.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context)
                        .setTitle("Delete place")
                        .setMessage("Are you sure?")
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrPlaceModel.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrPlaceModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvPlace, tvDesc;
        ImageView ivPlace;
        CardView cvPlaceLink;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPlace = itemView.findViewById(R.id.tvPlace);
            tvDesc = itemView.findViewById(R.id.tvPlaceDesc);
            ivPlace = itemView.findViewById(R.id.ivPlace);
            cvPlaceLink = itemView.findViewById(R.id.cvPlaceLink);
        }
    }
}
