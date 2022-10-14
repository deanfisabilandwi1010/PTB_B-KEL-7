package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.dosen_pembimbing;

import java.util.ArrayList;

public class dosen_pembimbingAdapter extends RecyclerView.Adapter<dosen_pembimbingAdapter.dosen_pembimbingViewHolder> {

    ArrayList<dosen_pembimbing> list_dosen = new ArrayList<>();

    itemPilihDosenOnclick listener;

    public dosen_pembimbingAdapter(ArrayList<dosen_pembimbing> list_dosen) {this.list_dosen = list_dosen;}

    public ArrayList<dosen_pembimbing> getList_dosen() {
        return list_dosen;
    }

    public void setList_dosen(ArrayList<dosen_pembimbing> list_dosen) {this.list_dosen = list_dosen;}

    public dosen_pembimbingAdapter(itemPilihDosenOnclick listener) {
        this.listener = listener;
    }


    public void setListener(itemPilihDosenOnclick listener) {
        this.listener = listener;
    }



    public dosen_pembimbingAdapter(ArrayList<dosen_pembimbing> list_dosen, itemPilihDosenOnclick listener) {
        this.list_dosen = list_dosen;
        this.listener = listener;
    }

    @NonNull
    @Override
    public dosen_pembimbingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detail_dosen, parent, false);


        return new dosen_pembimbingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dosen_pembimbingViewHolder holder, int position) {
        dosen_pembimbing dosen_pembimbing = list_dosen.get(position);
        holder.profil.setImageResource(R.drawable.logounand);
        holder.textNamaDosen.setText(dosen_pembimbing.getNamaDoping());
        holder.textNIK.setText(dosen_pembimbing.getNIKDoping());
        holder.textBidangDosen.setText(dosen_pembimbing.getBidangDoping());
    }

    @Override
    public int getItemCount() {
        return list_dosen.size();
    }



    public interface itemPilihDosenOnclick{
        void onItemPilihDosenClcik(dosen_pembimbing dosenPembimbing);
    }


    public class dosen_pembimbingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView profil;
        public TextView textNamaDosen,textNIK,textBidangDosen;
        public dosen_pembimbingViewHolder(@NonNull View itemView) {
            super(itemView);
            profil = itemView.findViewById(R.id.profil_dosen);
            textNamaDosen = itemView.findViewById(R.id.textNamaDosen);
            textNIK = itemView.findViewById(R.id.textNIK);
            textBidangDosen = itemView.findViewById(R.id.textBidangDosen);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            dosen_pembimbing dosenPembimbing = list_dosen.get(getAdapterPosition());
            listener.onItemPilihDosenClcik(dosenPembimbing);
        }
    }
}
