package ex2.t2.simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void XuLyCong(View view) {
        //Tìm, tham chiếu trên XML
        EditText editTextsoA = findViewById(R.id.edtA);
        EditText editTextsoB = findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);
        //Lấy dữ liệu
        String strA = editTextsoA.getText().toString();
        String strB = editTextsoB.getText().toString();
        String strKQ = editTextKQ.getText().toString();
        //Chuyển về số
        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);
        //Tính toán
        int tong = soA + soB;
        String strTong = String.valueOf(tong);
        //Hiện ra màn hình
        editTextKQ.setText(tong);

    }
}