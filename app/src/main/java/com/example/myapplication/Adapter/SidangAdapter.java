package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.datamodels.SeminarsItem;


import java.util.List;


public class SidangAdapter extends RecyclerView.Adapter<SidangAdapter.ListViewHolder> {

    private Context context;
    private List<SeminarsItem> seminarsItemList;

    public SidangAdapter(Context context, List<SeminarsItem> seminarsItemList){

        this.context = context;
        this.seminarsItemList = seminarsItemList;
    }

    @NonNull
    @Override
    public SidangAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.activity_list_permintaan_sidang, parent, false);

        SidangAdapter.ListViewHolder viewHolder = new SidangAdapter.ListViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
//        SeminarsItem data = (SeminarsItem) resultList.get(position);
//        holder.rvNama.setText(resultList.get(position).getName());
//        holder.rvJudul.setText(resultList.get(position).getOverview());
//        Glide.with(context)
//                .load("" + resultList.get(position).getPosterPath())
////                .apply(new RequestOptions().override(80, 80))
//                .into(holder.imgPhoto);

//        SeminarsItem data = (SeminarsItem) seminarsItemList.get(position);
//        Glide.with(holder.itemView.getContext())
//                .load(seminarsItemList.getPhoto())
//                .apply(new RequestOptions().override(80, 80))
//                .into(holder.imgPhoto);
        holder.rvNama.setText(seminarsItemList.get(position).getThesis().getStudent(position).getName());
        holder.rvJudul.setText(seminarsItemList.get(position).getThesis().getTitle());
        holder.rvDate.setText(seminarsItemList.get(position).getThesis().getUpdatedAt());

    }

    @Override
    public int getItemCount() {

        return seminarsItemList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView rvDate, rvNama, rvJudul;



        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.avatar);
            rvNama = itemView.findViewById(R.id.rvNama);
            rvJudul = itemView.findViewById(R.id.rvJudul);
            rvDate = itemView.findViewById(R.id.rvDate);
        }
    }
}
