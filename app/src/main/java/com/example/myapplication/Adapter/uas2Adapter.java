package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.datamodels.ThesesItem;
import com.example.myapplication.datamodels.ThesisItem;

import java.util.ArrayList;
import java.util.List;

public class uas2Adapter extends RecyclerView.Adapter<uas2Adapter.ViewHolder> {

    private List<ThesesItem> itemList = new ArrayList<>();

    public void setItemList(List<ThesesItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public uas2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detailmahasiswa_ta, parent, false);
        return new uas2Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull uas2Adapter.ViewHolder holder, int position) {
        ThesesItem theses = itemList.get(position);
        holder.namamhs.setText(theses.getStudentName());
        holder.nimmhs.setText(theses.getStudentNim());
        holder.judultugas.setText((CharSequence) theses.getTitle());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView namamhs, nimmhs, judultugas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namamhs = itemView.findViewById(R.id.txt_namamhsTA);
            nimmhs = itemView.findViewById(R.id.txt_nimMhsaTA);
            judultugas = itemView.findViewById(R.id.txt_judulTAmhswa);

        }
    }
}
