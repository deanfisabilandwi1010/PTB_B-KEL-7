//package com.example.myapplication;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication.models.logbook;
//
//import java.util.ArrayList;
//
//public class list_logbook extends AppCompatActivity implements logbookAdapter.ItemlbClickListener{
//    private RecyclerView rvlb;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_logbook);
//
//        rvlb = findViewById(R.id.rv_lb);
//
//        logbookAdapter adapter = new logbookAdapter(getlogbook());
//        adapter.setListener((logbookAdapter.ItemlbClickListener) this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//
//        rvlb.setLayoutManager(layoutManager);
//        rvlb.setAdapter(adapter);
//      }
//
//
//    public ArrayList<logbook> getlogbook(){
//        ArrayList<logbook> list_lb = new ArrayList<>();
//
//        list_lb.add(new logbook(
//                null,
//                null,
//                "20 Oktober 2022",
//                "Merevisi Bab I, bagian latar belakang"
//
//        ));
//
//        list_lb.add(new logbook(
//                null,
//                null,
//                "20 Oktober 2022",
//                "Merevisi Bab I, bagian latar belakang"
//        ));
//
//        list_lb.add(new logbook(
//                null,
//                null,
//                "20 Oktober 2022",
//                "Merevisi Bab I, bagian latar belakang"
//        ));
//
//        list_lb.add(new logbook(
//                null,
//                null,
//                "20 Oktober 2022",
//                "Merevisi Bab I, bagian latar belakang"
//        ));
//
//        list_lb.add(new logbook(
//                null,
//                null,
//                "20 Oktober 2022",
//                "Merevisi Bab I, bagian latar belakang"
//        ));
//
//
//        return list_lb;
//
//    }
//
//
//    @Override
//    public void onItemListlogbook(logbook logbook) {
////        Intent detailTAOld = new Intent(this, detail_lb.class);
////        detailTAOld.putExtra("", logbook.getNamamahasiswa());
////        detailTAOld.putExtra("judul_TA", logbook.getJudul_ta());
////        detailTAOld.putExtra("dosping_old", logbook.getPembimbing());
////        startActivity(detailTAOld);
//    }
//
//    @Override
//    public void onItemlbClick(logbook logbook) {
//
//    }
//}
//
