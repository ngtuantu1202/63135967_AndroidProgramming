package ntu.ngtuantu.simplebottomnavigation;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ntu.ngtuantu.simplebottomnavigation.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navLisnener);

        //Fragment show đầu tiên
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AlgorithmFragment()).commit();
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navLisnener = item ->{
        //Sử dụng switch để lấy đc fragment thông qua id
        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.algorithm)
            selectedFragment = new AlgorithmFragment();
        else if (itemId == R.id.course) {
            selectedFragment = new CourseFragment();
        } else if (itemId == R.id.profile) {
            selectedFragment = new ProfileFragment();
        }

        //Thay thế fragment này với fragment khác
        if (selectedFragment != null)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        return true;
    };
}