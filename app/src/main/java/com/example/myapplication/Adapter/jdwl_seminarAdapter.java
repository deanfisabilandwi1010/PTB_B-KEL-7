package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.jadwal_seminar;


import java.util.ArrayList;

public class jdwl_seminarAdapter extends RecyclerView.Adapter<jdwl_seminarAdapter.jdwl_seminarViewHolder> {

    ArrayList<jadwal_seminar> list_seminar = new ArrayList<>();

    jdwl_seminarAdapter.itemPilihSeminarOnClick listener;

    public jdwl_seminarAdapter(ArrayList<jadwal_seminar> list_seminar) {this.list_seminar = list_seminar;}

    public ArrayList<jadwal_seminar> getList_seminar() {
        return list_seminar;
    }

    public void setList_seminar(ArrayList<jadwal_seminar> list_seminar) {this.list_seminar = list_seminar;}

    public jdwl_seminarAdapter(jdwl_seminarAdapter.itemPilihSeminarOnClick listener) {
        this.listener = listener;
    }


    public void setListener(jdwl_seminarAdapter.itemPilihSeminarOnClick listener) {
        this.listener = listener;
    }



    public jdwl_seminarAdapter(ArrayList<jadwal_seminar> list_seminar, jdwl_seminarAdapter.itemPilihSeminarOnClick listener) {
        this.list_seminar = list_seminar;
        this.listener = listener;
    }

    @NonNull
    @Override
    public jdwl_seminarAdapter.jdwl_seminarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detail_seminar, parent, false);


        return new jdwl_seminarAdapter.jdwl_seminarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull jdwl_seminarAdapter.jdwl_seminarViewHolder holder, int position) {
        jadwal_seminar jadwal_seminar = list_seminar.get(position);
        holder.gambar.setImageResource(R.drawable.logounand);
        holder.textmhsSeminar.setText(jadwal_seminar.getMhsSeminar());
        holder.textJudultugasakhir.setText(jadwal_seminar.getJudultugasakhir());
        holder.textRuangan.setText(jadwal_seminar.getRuangan());
        holder.textDosPenguji.setText(jadwal_seminar.getDospenguji());
    }

    @Override
    public int getItemCount() {
        return list_seminar.size();
    }


    public interface itemPilihSeminarOnClick{
        void onItemPilihSeminarClcik(jadwal_seminar jadwalSeminar);
    }


    public class jdwl_seminarViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView gambar;
        public TextView textmhsSeminar,textJudultugasakhir,textRuangan,textDosPenguji;
        public jdwl_seminarViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.seminarPict);
            textmhsSeminar = itemView.findViewById(R.id.textMhsSeminar);
            textJudultugasakhir = itemView.findViewById(R.id.textjudulTASeminar);
            textRuangan = itemView.findViewById(R.id.textRuanganSem);
            textDosPenguji = itemView.findViewById(R.id.textPengujiSem);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            jadwal_seminar jadwalSeminar = list_seminar.get(getAdapterPosition());
            listener.onItemPilihSeminarClcik(jadwalSeminar);
        }
    }


}
