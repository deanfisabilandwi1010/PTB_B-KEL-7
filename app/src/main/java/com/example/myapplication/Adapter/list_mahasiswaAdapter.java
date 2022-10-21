package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.list_mahasiswa_ta;

import java.util.ArrayList;

public class list_mahasiswaAdapter extends RecyclerView.Adapter<list_mahasiswaAdapter.list_mahasiswaViewHolder> {


    ArrayList<list_mahasiswa_ta> list_mahasiswa = new ArrayList<>();

    public list_mahasiswaAdapter(ArrayList<list_mahasiswa_ta> list_mahasiswa) {
        this.list_mahasiswa = list_mahasiswa;
    }


    @NonNull
    @Override
    public list_mahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_card_view_cari_mahasiswa, parent, false);

        return new list_mahasiswaViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull list_mahasiswaViewHolder holder, int position) {

        list_mahasiswa_ta list_mahasiswa_ta = list_mahasiswa.get(position);
        holder.imagelist_mahasiswa_ta.setImageResource(R.drawable.ic_avatar1);
        holder.textnamamahasiswa.setText(list_mahasiswa_ta.getNamamahasiswa());
        holder.textjudul_ta.setText(list_mahasiswa_ta.getJudul_ta());
        holder.textpembimbing.setText(list_mahasiswa_ta.getPembimbing());


    }

    @Override
    public int getItemCount() {
        return list_mahasiswa.size();
    }

    public class list_mahasiswaViewHolder extends RecyclerView.ViewHolder{

        public ImageView imagelist_mahasiswa_ta;
        public TextView textnamamahasiswa, textjudul_ta, textpembimbing;


        public list_mahasiswaViewHolder(@NonNull View itemView) {

            super(itemView);
            imagelist_mahasiswa_ta = itemView.findViewById(R.id.imagelistmahasiswata);
            textnamamahasiswa = itemView.findViewById(R.id.textNama);
            textjudul_ta = itemView.findViewById(R.id.judul_ta);
            textpembimbing = itemView.findViewById(R.id.namadospem);

        }
    }



}

