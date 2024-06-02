package ntu.ngtuantu.test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Cau1Fragment extends Fragment {

    //1.Khai bao
    EditText editNhap;
    Spinner spinnerNhap;
    Spinner spinnerXuat;
    TextView txtKQ;

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
        editNhap = viewCau1.findViewById(R.id.edtNhap);
        spinnerNhap = viewCau1.findViewById(R.id.spnNhap);
        spinnerXuat = viewCau1.findViewById(R.id.spnXuat);
        txtKQ = viewCau1.findViewById(R.id.edtXuat);
        Button buttonDoi = viewCau1.findViewById(R.id.btnDoi);
        //4.Lang nghe su kien
        buttonDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyDoi(v);
            }
        });
        return viewCau1;
    }
    public void XuLyDoi(View view) {
        // Lấy dữ liệu
        double giaTriNhap = Double.parseDouble(editNhap.getText().toString());
        String donViNhap = spinnerNhap.getSelectedItem().toString();
        String donViXuat = spinnerXuat.getSelectedItem().toString();

        double ketQua = chuyenDoi(donViNhap, donViXuat, giaTriNhap);

        // Hiển thị kết quả
        txtKQ.setText(String.valueOf(ketQua));
    }

    private double chuyenDoi(String donViNhap, String donViXuat, double giaTriNhap) {
        double ketQua = 0;

        switch (donViNhap) {
            case "km":
                if (donViXuat.equals("m"))
                    ketQua = giaTriNhap * 1000;
                else if (donViXuat.equals("cm"))
                    ketQua = giaTriNhap * 100000;
                else if (donViXuat.equals("mm"))
                    ketQua = giaTriNhap * 1000000;
                else
                    ketQua = giaTriNhap;
                break;
            case "m":
                if (donViXuat.equals("km"))
                    ketQua = giaTriNhap / 1000;
                else if (donViXuat.equals("cm"))
                    ketQua = giaTriNhap * 100;
                else if (donViXuat.equals("mm"))
                    ketQua = giaTriNhap * 1000;
                else
                    ketQua = giaTriNhap;
                break;
            case "cm":
                if (donViXuat.equals("km"))
                    ketQua = giaTriNhap / 100000;
                else if (donViXuat.equals("m"))
                    ketQua = giaTriNhap / 100;
                else if (donViXuat.equals("mm"))
                    ketQua = giaTriNhap * 10;
                else
                    ketQua = giaTriNhap;
                break;
            case "mm":
                if (donViXuat.equals("km"))
                    ketQua = giaTriNhap / 1000000;
                else if (donViXuat.equals("m"))
                    ketQua = giaTriNhap / 1000;
                else if (donViXuat.equals("cm"))
                    ketQua = giaTriNhap / 10;
                else
                    ketQua = giaTriNhap;
                break;
        }
        return ketQua;
    }
}
