package ntu_63135967.introduction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_main);
    }
    public void XuLyTen(View view)
    {
        String ten = "Nguyễn Tuấn Tú";
        Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
    }
    public void XuLyLop(View view)
    {
        String lop = "Lớp: CNTT-2";
        Toast.makeText(this, lop, Toast.LENGTH_SHORT).show();
    }
    public void XuLyMSSV(View view)
    {
        String mssv = "63135967";
        Toast.makeText(this, mssv, Toast.LENGTH_SHORT).show();
    }
    public void XuLyEmail(View view)
    {
        String email = "tu.nt.63cntt@ntu.edu.vn";
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
    }
}