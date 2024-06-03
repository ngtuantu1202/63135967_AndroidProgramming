package thi.nguyentuantu63135967.dethi2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,
                new WelcomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home) {
                    selectedFragment = new WelcomeFragment();
                }else if (itemId == R.id.nav_profile) {
                    selectedFragment = new MyCVFragment();
                }else if (itemId == R.id.nav_cau1) {
                    selectedFragment = new UnitConverterFragment();
                } else if (itemId == R.id.nav_cau2) {
                    selectedFragment = new WelknownCoffeeFragment();
                } else if (itemId == R.id.nav_cau3) {
                    selectedFragment = new SubjectsFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,
                        selectedFragment).commit();
                return true;
            }
        });
    }
}