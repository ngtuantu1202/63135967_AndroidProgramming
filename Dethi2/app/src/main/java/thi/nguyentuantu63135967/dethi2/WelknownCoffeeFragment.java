package thi.nguyentuantu63135967.dethi2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelknownCoffeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelknownCoffeeFragment extends Fragment {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas = new ArrayList<>();
    //2. Khai bao bien dai dien view can tuong tac
    RecyclerView recyclerViewLandscape;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WelknownCoffeeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WelknownCoffeeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WelknownCoffeeFragment newInstance(String param1, String param2) {
        WelknownCoffeeFragment fragment = new WelknownCoffeeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerViewDatas.add(new LandScape("Bách Viên, đường 2/4", "bachvien"));
        recyclerViewDatas.add(new LandScape("Ôm, đường 30/10", "ca"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCau3 = inflater.inflate(R.layout.fragment_welknown_coffee, container, false);

        recyclerViewLandscape = viewCau3.findViewById(R.id.ryCau3);

        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(viewCau3.getContext());
        recyclerViewLandscape.setLayoutManager(layoutLinear);

        landScapeAdapter = new LandScapeAdapter(viewCau3.getContext(), recyclerViewDatas);

        recyclerViewLandscape.setAdapter(landScapeAdapter);

        return viewCau3;
    }
}