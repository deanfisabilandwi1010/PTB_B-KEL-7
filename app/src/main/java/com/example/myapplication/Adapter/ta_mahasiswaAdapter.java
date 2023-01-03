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
import com.example.myapplication.models.ta_mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class ta_mahasiswaAdapter extends RecyclerView.Adapter<ta_mahasiswaAdapter.ta_mahasiswaViewHolder> {

    ArrayList<ta_mahasiswa> list_ta = new ArrayList<>();

    ItemPermintaanTAClickListener listener;

    private List<ThesisItem> itemList;
    public ta_mahasiswaAdapter( List<ThesisItem> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<ta_mahasiswa> getList_ta() {
        return list_ta;
    }

    public void setList_ta(ArrayList<ta_mahasiswa> list_ta) {
        this.list_ta = list_ta;
    }
//
//    public ta_mahasiswaAdapter(ArrayList<ta_mahasiswa> list_ta, ItemPermintaanTAClickListener listener) {
//        this.list_ta = list_ta;
//        this.listener = listener;
//    }

    public void setListener(ItemPermintaanTAClickListener listener) {
        this.listener = listener;
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
    ThesisItem ta_mahasiswa = itemList.get(position);
    holder.gambar.setImageResource(R.drawable.fotodosen);
    holder.textJudul_ta.setText(ta_mahasiswa.getTitle());
    holder.textidmhs.setText(ta_mahasiswa.getStudentId());
    holder.textNIM.setText(ta_mahasiswa.getId());
    holder.textyear.setText(ta_mahasiswa.getStatus());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface ItemPermintaanTAClickListener{
        void onItemPermintaanTAClick(ta_mahasiswa taMahasiswa);
    }

    public class ta_mahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView gambar;
        public TextView textNama,textJudul_ta,textNIM,textidmhs,textyear;
        public ta_mahasiswaViewHolder(@NonNull View itemView){
            super(itemView);
            gambar = itemView.findViewById(R.id.profil_dosen);
            textJudul_ta = itemView.findViewById(R.id.text_judulTA);
            textNIM = itemView.findViewById(R.id.textNIM);
//



            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            ta_mahasiswa taMahasiswa = list_ta.get(getAdapterPosition());
            listener.onItemPermintaanTAClick(taMahasiswa);
        }
    }
}
