package ntu.ngtuantu.test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Cau3Fragment extends Fragment {
    //1.Khai bao bien toan cuc
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas = new ArrayList<>();
    //2. Khai bao bien dai dien view can tuong tac
    RecyclerView recyclerViewLandscape;


    public Cau3Fragment() {
        // Required empty public constructor
    }


    public static Cau3Fragment newInstance(String param1, String param2) {
        Cau3Fragment fragment = new Cau3Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //3. Them du lieu
//        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
//        LandScape ls1 = new LandScape("vinh_ha_long", "Vịnh Hạ Long");
//        dsDuLieu.add(ls1);
//        dsDuLieu.add(new LandScape("ponagar", "Tháp bà Ponagar"));
//        dsDuLieu.add(new LandScape("tram_huong", "Tháp Trầm Hương"));
        recyclerViewDatas.add(new LandScape("vinh_ha_long", "Vịnh Hạ Long"));
        recyclerViewDatas.add(new LandScape("ponagar", "Tháp bà Ponagar"));
        recyclerViewDatas.add(new LandScape("tram_huong", "Tháp Trầm Hương"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCau3 = inflater.inflate(R.layout.fragment_cau3, container, false);
        //4. Tim dieu khien Recycler
        recyclerViewLandscape = viewCau3.findViewById(R.id.ryCau3);
        //5. Tao layout manager de dat bo cuc cho Recycler
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(viewCau3.getContext());
        recyclerViewLandscape.setLayoutManager(layoutLinear);
//        RecyclerView.LayoutManager layoutLinearHorizonal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewLandscape.setLayoutManager(layoutLinearHorizonal);
//        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(this, 2);
//        recyclerViewLandscape.setLayoutManager(layoutGrid);
        //6. tao adapte gan vao nguon du lieu
        landScapeAdapter = new LandScapeAdapter(viewCau3.getContext(), recyclerViewDatas);
        //7. gan adapter vao recycler
        recyclerViewLandscape.setAdapter(landScapeAdapter);

        return viewCau3;
    }
}