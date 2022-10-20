package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.jadwal_sidang;

import java.util.ArrayList;

public class jdwl_sidangAdapter extends RecyclerView.Adapter<jdwl_sidangAdapter.jdwl_sidangViewHolder> {

    ArrayList<jadwal_sidang> list_sidang = new ArrayList<>();

    jdwl_sidangAdapter.itemPilihSidangOnClick listener;

    public jdwl_sidangAdapter(ArrayList<jadwal_sidang> list_sidang) {this.list_sidang = list_sidang;}

    public ArrayList<jadwal_sidang> getList_sidang() {
        return list_sidang;
    }

    public void setList_sidang(ArrayList<jadwal_sidang> list_sidang) {this.list_sidang = list_sidang;}

    public jdwl_sidangAdapter(jdwl_sidangAdapter.itemPilihSidangOnClick listener) {
        this.listener = listener;
    }


    public void setListener(jdwl_sidangAdapter.itemPilihSidangOnClick listener) {
        this.listener = listener;
    }



    public jdwl_sidangAdapter(ArrayList<jadwal_sidang> list_sidang, jdwl_sidangAdapter.itemPilihSidangOnClick listener) {
        this.list_sidang = list_sidang;
        this.listener = listener;
    }

    @NonNull
    @Override
    public jdwl_sidangAdapter.jdwl_sidangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detail_sidang, parent, false);


        return new jdwl_sidangAdapter.jdwl_sidangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull jdwl_sidangAdapter.jdwl_sidangViewHolder holder, int position) {
        jadwal_sidang jadwal_sidang = list_sidang.get(position);
        holder.gambar.setImageResource(R.drawable.logounand);
        holder.textmhsSidang.setText(jadwal_sidang.getMhsSidang());
        holder.textJudultugasakhir.setText(jadwal_sidang.getJudultugasakhir());
        holder.textRuangan.setText(jadwal_sidang.getRuangan());
        holder.textDosPenguji.setText(jadwal_sidang.getDospenguji());
    }

    @Override
    public int getItemCount() {
        return list_sidang.size();
    }


    public interface itemPilihSidangOnClick{
        void onItemPilihSidangClcik(jadwal_sidang jadwalSidang);
    }


    public class jdwl_sidangViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView gambar;
        public TextView textmhsSidang,textJudultugasakhir,textRuangan,textDosPenguji;
        public jdwl_sidangViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.sidangPict);
            textmhsSidang = itemView.findViewById(R.id.textMhsSidang);
            textJudultugasakhir = itemView.findViewById(R.id.textjudulTASidang);
            textRuangan = itemView.findViewById(R.id.textRuangan);
            textDosPenguji = itemView.findViewById(R.id.textPenguji);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            jadwal_sidang jadwalSidang = list_sidang.get(getAdapterPosition());
            listener.onItemPilihSidangClcik(jadwalSidang);
        }
    }


}
