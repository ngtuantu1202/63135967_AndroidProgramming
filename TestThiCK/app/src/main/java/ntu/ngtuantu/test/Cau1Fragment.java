package ntu.ngtuantu.test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Cau1Fragment extends Fragment {

    //1.Khai bao
    EditText editNhap, editXuat;
    Button buttonDoi;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public Cau1Fragment() {

    }

    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //2. Tra ve view
        View viewCau1 = inflater.inflate(R.layout.fragment_cau1, container, false);
        //3. Tim dieu khien trong view
        editNhap =  viewCau1.findViewById(R.id.edtNhap);
        editXuat = viewCau1.findViewById(R.id.edtXuat);
        buttonDoi = viewCau1.findViewById(R.id.btnDoi);
        //4.Lang nghe su kien
        buttonDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nhap = editNhap.getText().toString();
                String Xuat = editXuat.getText().toString();
                //
                if(!Nhap.isEmpty())
                {
                    Toast.makeText(viewCau1.getContext(), "m->km", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(viewCau1.getContext(), "km->m", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return viewCau1;
    }
}