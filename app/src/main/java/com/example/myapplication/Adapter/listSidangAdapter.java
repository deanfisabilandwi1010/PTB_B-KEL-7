package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresOptIn;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.models.list_mahasiswa_sidang;

import java.util.ArrayList;


public class listSidangAdapter extends RecyclerView.Adapter<listSidangAdapter.ListViewHolder> {

    private ArrayList<list_mahasiswa_sidang> listSidang;

    public listSidangAdapter (ArrayList<list_mahasiswa_sidang> list){
        this.listSidang = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_mahasiswa_sidang, parent, false);
        return new ListViewHolder(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        list_mahasiswa_sidang data = listSidang.get(position);
        Glide.with(holder.itemView.getContext())
                .load(data.getPhoto())
                .apply(new RequestOptions().override(80, 80))
                .into(holder.imgPhoto);
        holder.nama.setText(data.getNamaMSidang());
        holder.judul.setText(data.getJudul());
        holder.date.setText(data.getJadwal());

    }

    @Override
    public int getItemCount() {


        return listSidang.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView date, nama, judul;



        public ListViewHolder(@NonNull View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.avatar);
            nama = itemview.findViewById(R.id.nama);
            judul = itemview.findViewById(R.id.judul);
            date = itemview.findViewById(R.id.date);
        }
    }
}
