package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.list_logbook;
import com.example.myapplication.models.logbook;

import java.util.ArrayList;

public class logbookAdapter extends RecyclerView.Adapter<logbookAdapter.logbookViewHolder> {

    ArrayList<logbook> list_lb = new ArrayList<>();

    ItemlbClickListener listener;

    public logbookAdapter(ArrayList<logbook> list_lb) {

        this.list_lb = list_lb;
    }

    public ArrayList<logbook> getList_lb() {

        return list_lb;
    }

    public void setList_ta(ArrayList<logbook> list_lb) {

        this.list_lb = list_lb;
    }

    public logbookAdapter(ArrayList<logbook> list_lb, logbookAdapter.ItemlbClickListener listener) {
        this.list_lb = list_lb;
        this.listener = listener;
    }

    public void setListener(ItemlbClickListener listener) {

        this.listener = listener;
    }

    @NonNull
    @Override
    public logbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_logbook, parent, false);


        return new logbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull logbookViewHolder holder, int position) {
        logbook logbook = list_lb.get(position);
//        holder.book.setImageResource(R.drawable.ic_avatar1);
//        holder.done.setImageResource(R.drawable.ic_avatar1);
        holder.textTanggal.setText(logbook.getTanggal());
        holder.textRincian.setText(logbook.getRincian());


    }

    @Override
    public int getItemCount() {
        return list_lb.size();
    }

    public interface ItemlbClickListener{

        void onItemListlogbook(logbook logbook);

        void onItemlbClick(logbook logbook);
    }

    public class logbookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView book,done;
        public TextView textTanggal,textRincian;
        public logbookViewHolder(@NonNull View itemView){
            super(itemView);
            book = itemView.findViewById(R.id.buku);
            textTanggal = itemView.findViewById(R.id.tanggal);
            textRincian = itemView.findViewById(R.id.rincian);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            logbook taMahasiswa = list_lb.get(getAdapterPosition());
            listener.onItemListlogbook(taMahasiswa);
        }
    }
}

