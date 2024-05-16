package ntu.ngtuantu.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dstinhthanh;
    ArrayAdapter<String> adapterTinh;
    ListView lvTinhThanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDK();

        dstinhthanh = new ArrayList<String>();
        dstinhthanh.add("Nha Trang");
        dstinhthanh.add("Đà Nẵng");
        dstinhthanh.add("Bình Định");
        dstinhthanh.add("Quy Nhơn");
        dstinhthanh.add("Phú Yên");
        dstinhthanh.add("TP Hồ Chí Minh");
        dstinhthanh.add("Hà Nội");
        dstinhthanh.add("Thừa Thiên Huế");
        dstinhthanh.add("Hải Phòng");
        dstinhthanh.add("Cao Bằng");
        dstinhthanh.add("Yên Bái");
        dstinhthanh.add("Lạng Sơn");
        dstinhthanh.add("Đồng Nai");

        adapterTinh = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dstinhthanh);

        lvTinhThanh.setAdapter(adapterTinh);

        lvTinhThanh.setOnItemClickListener(BoLangNghe);


        //Cách 1:
//        lvTinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String tenTinhThanh = dstinhthanh.get(position);
//                Toast.makeText(MainActivity.this, "Bạn vừa chọn: " + tenTinhThanh, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    void TimDK(){
        lvTinhThanh = findViewById(R.id.lvtinhthanh);
    }

    //Tạo bộ lắng nghe và xử lý sự kiện OnItemClick
    //Cách 2:
    AdapterView.OnItemClickListener BoLangNghe = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String tenTinhThanh = dstinhthanh.get(position);
            Toast.makeText(MainActivity.this, "Bạn vừa chọn: " + tenTinhThanh, Toast.LENGTH_SHORT).show();
        }
    };

}