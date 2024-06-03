package thi.nguyentuantu63135967.dethi2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UnitConverterFragment extends Fragment {
    EditText editNhap;
    Spinner spinnerNhap;
    TextView txtKQ;

    public UnitConverterFragment() {
        // Required empty public constructor
    }

    public static UnitConverterFragment newInstance(String param1, String param2) {
        UnitConverterFragment fragment = new UnitConverterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCau1 = inflater.inflate(R.layout.fragment_unit_converter, container, false);
        editNhap = viewCau1.findViewById(R.id.edtNhap);
        spinnerNhap = viewCau1.findViewById(R.id.spnNhap);
        txtKQ = viewCau1.findViewById(R.id.edtXuat);
        Button buttonDoi = viewCau1.findViewById(R.id.btnDoi);
        buttonDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyDoi();
            }
        });

        return viewCau1;
    }

    public void XuLyDoi() {
        try {
            // Lấy dữ liệu
            double giaTriNhap = Double.parseDouble(editNhap.getText().toString());
            String donViNhap = spinnerNhap.getSelectedItem().toString();
            double ketQua = chuyenDoi(donViNhap, giaTriNhap);
            // Hiển thị kết quả
            txtKQ.setText(String.valueOf(ketQua));
        } catch (NumberFormatException e) {
            txtKQ.setText("KO HỢP LỆ");
        }
    }

    // chuyenDoi method to perform the actual conversion
    private double chuyenDoi(String donViNhap, double giaTriNhap) {
        double ketQua = 0;
        switch (donViNhap) {
            case "kg":
                ketQua = giaTriNhap * 1000;
                break;
            case "km":
                ketQua = giaTriNhap * 1000;
                break;
            case "byte":
                ketQua = giaTriNhap * 8;
                break;
            default:
                throw new IllegalArgumentException(donViNhap);
        }
        return ketQua;
    }
}
