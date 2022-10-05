package com.example.myapplication.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.ta_mahasiswa;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ta_mahasiswaAdapter extends RecyclerView.Adapter<ta_mahasiswaAdapter.ta_mahasiswaViewHolder> {

    ArrayList<ta_mahasiswa> list_ta = new ArrayList<>();

    public ta_mahasiswaAdapter(ArrayList<ta_mahasiswa> list_ta) {
        this.list_ta = list_ta;
    }

    public ArrayList<ta_mahasiswa> getList_ta() {
        return list_ta;
    }

    public void setList_ta(ArrayList<ta_mahasiswa> list_ta) {
        this.list_ta = list_ta;
    }

    @NonNull
    @Override
    public ta_mahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detailta, parent, false);


        return new ta_mahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ta_mahasiswaViewHolder holder, int position) {
    ta_mahasiswa ta_mahasiswa = list_ta.get(position);
    holder.gambar.setImageResource(R.drawable.fotodosen);
    holder.textNama.setText(ta_mahasiswa.getNama());
    holder.textJudul_ta.setText(ta_mahasiswa.getJudul());
    holder.text_doping.setText(ta_mahasiswa.getDoping());
    }

    @Override
    public int getItemCount() {
        return list_ta.size();
    }

    public class ta_mahasiswaViewHolder extends RecyclerView.ViewHolder {

        public ImageView gambar;
        public TextView textNama,textJudul_ta,text_doping;
        public ta_mahasiswaViewHolder(@NonNull View itemView){
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar);
            textNama = itemView.findViewById(R.id.textNama);
            textJudul_ta = itemView.findViewById(R.id.textJudul_ta);
            text_doping = itemView.findViewById(R.id.textDoping);
        }



    }
}
