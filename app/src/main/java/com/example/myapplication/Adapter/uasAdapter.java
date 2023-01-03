package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.datamodels.ThesisItem;
import com.example.myapplication.datamodels.PermintaanTAResponse;

import java.util.ArrayList;
import java.util.List;

public class uasAdapter extends RecyclerView.Adapter<uasAdapter.ViewHolder> {

    private List<ThesisItem> itemList = new ArrayList<>();

    public void setItemList(List<ThesisItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detailta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThesisItem thesis = itemList.get(position);
        holder.TextJudulTA.setText(thesis.getTitle());
        holder.textDate.setText(thesis.getUpdatedAt());
        if(thesis.getStatus() == 1){
            holder.CheckIMG.setImageResource(R.drawable.check);
        } else {
            holder.CheckIMG.setImageResource(R.drawable.cancel);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView TextJudulTA, TextId, textDate;
        public ImageView CheckIMG;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TextJudulTA = itemView.findViewById(R.id.text_judulTugasAkhir);
            textDate = itemView.findViewById(R.id.txt_idtanggal);
            CheckIMG = itemView.findViewById(R.id.checklist);

        }
}
}
