package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.datamodels.SeminarsItem;
import com.example.myapplication.listPermintaanSeminar;
import com.example.myapplication.listPermintaanSidang;


import java.util.ArrayList;
import java.util.List;


public class SidangAdapter extends RecyclerView.Adapter<SidangAdapter.ListViewHolder> {


    private List<SeminarsItem> seminarsItemList = new ArrayList<>();


    public SidangAdapter(listPermintaanSidang listPermintaanSidang, List<SeminarsItem> seminarsItemList){
        this.seminarsItemList = seminarsItemList;
        notifyDataSetChanged();
    }

    ItemSeminarClickListener listener;

    public void setListener(ItemSeminarClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_card_view_mahasiswa_sidang, parent, false);

//        View view;
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        view = inflater.inflate(R.layout.activity_list_permintaan_sidang, parent, false);

        //SidangAdapter.ListViewHolder viewHolder = new SidangAdapter.ListViewHolder(view);
        return new ListViewHolder(view);

    }



    @Override
    public int getItemCount() {

        return seminarsItemList.size();
    }

    public interface ItemSeminarClickListener{
        void onItemPermintaanClick(SeminarsItem sidang );
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        SeminarsItem sidang = seminarsItemList.get(position);
        holder.imgPhoto.setImageResource(R.drawable.ic_avatar4);
        String str1 = sidang.getThesis().getStudent().getName();
        String str2 = str1.toLowerCase();
        holder.rvNama.setText(StringFormatter.capitalizeWord(str2));
        holder.rvJudul.setText(sidang.getThesis().getTitle());



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

//        holder.rvNama.setText(seminarsItemList.get(position).getThesis().getStudent(position).getName());
//        holder.rvJudul.setText(seminarsItemList.get(position).getThesis().getTitle());
//        holder.rvDate.setText(seminarsItemList.get(position).getThesis().getUpdatedAt());

    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgPhoto;
        TextView rvDate, rvNama, rvJudul;



        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.avatar);
            rvNama = itemView.findViewById(R.id.rvNama);
            rvJudul = itemView.findViewById(R.id.rvJudul);
            rvDate = itemView.findViewById(R.id.rvDate);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            SeminarsItem sidang = seminarsItemList.get(getAdapterPosition());
            listener.onItemPermintaanClick(sidang);

        }
    }

    private static class StringFormatter {
        public static String capitalizeWord(String str){
            String words[]= str.split("\\s");
            String capitalizeWord = "";

            for (String w:words){
                String first = w.substring(0,1);
                String afterfirst = w. substring(1);
                capitalizeWord = first.toUpperCase()+afterfirst+"";
            }
            return capitalizeWord.trim();

        }
    }
}
