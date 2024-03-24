package ntu_63135967.cau2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void XuLyDoi(View view)
    {
        //Tìm, tham chiếu trên xml
        EditText editNhap = findViewById(R.id.editNhap);
        Spinner spinnerNhap = findViewById(R.id.spinnerNhap);
        Spinner spinnerXuat = findViewById(R.id.spinnerXuat);
        //Láy dữ liệu
        double giaTriNhap = Double.parseDouble(editNhap.getText().toString());
        String donViNhap = spinnerNhap.getSelectedItem().toString();
        String donViXuat = spinnerXuat.getSelectedItem().toString();

        double ketQua = chuyenDoi(donViNhap, donViXuat, giaTriNhap);
        // Hiển thị kết quả
        TextView txtKQ = findViewById(R.id.editTextNumber);
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
                else if (donViXuat.equals("Cencmtimeter"))
                    ketQua = giaTriNhap / 10;
                else
                    ketQua = giaTriNhap;
                break;
        }
        return ketQua;
    }

}