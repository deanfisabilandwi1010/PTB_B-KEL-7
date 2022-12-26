package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.list_peserta_seminar;
import com.example.myapplication.models.pesertaseminar;
import com.example.myapplication.models.ta_mahasiswa;

import java.util.ArrayList;

public class pesertaseminarAdapter extends RecyclerView.Adapter<pesertaseminarAdapter.pesertaseminarViewHolder> {

    ArrayList<pesertaseminar> list_ps = new ArrayList<>();

    ItempsClickListener listener;

    public pesertaseminarAdapter(ArrayList<pesertaseminar> list_ps) {

        this.list_ps = list_ps;
    }

    public ArrayList<pesertaseminar> getList_ps() {

        return list_ps;
    }

    public void setList_pesertaseminar(ArrayList<pesertaseminar> list_ps) {

        this.list_ps = list_ps;
    }

    public pesertaseminarAdapter(ArrayList<pesertaseminar> list_lb, pesertaseminarAdapter.ItempsClickListener listener) {
        this.list_ps = list_ps;
        this.listener = listener;
    }

    public void setListener(ItempsClickListener listener) {

        this.listener = listener;
    }

    @NonNull
    @Override
    public pesertaseminarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_peserta_seminar, parent, false);


        return new pesertaseminarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pesertaseminarAdapter.pesertaseminarViewHolder holder, int position) {
        pesertaseminar pesertaseminar = list_ps.get(position);
        holder.textNama.setText(pesertaseminar.getNama());
        holder.textNim.setText(pesertaseminar.getNim());


    }

    @Override
    public int getItemCount() {
        return list_ps.size();
    }

    public interface ItempsClickListener {

        void onItemListpesertaseminar(pesertaseminar pesertaseminar);

        void onItempsClick(pesertaseminar pesertaseminar);
    }

    public class pesertaseminarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textNama, textNim;

        public pesertaseminarViewHolder(@NonNull View itemView) {
            super(itemView);

            textNama = itemView.findViewById(R.id.nama_mhs);
            textNim = itemView.findViewById(R.id.nim);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            pesertaseminar pesertaseminar = list_ps.get(getAdapterPosition());
            listener.onItempsClick(pesertaseminar);

        }
    }
}


