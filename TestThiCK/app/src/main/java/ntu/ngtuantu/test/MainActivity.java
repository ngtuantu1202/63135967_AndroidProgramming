package ntu.ngtuantu.test;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import ntu.ngtuantu.test.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new ProfileFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_profile);
        //Lang nghe su kien
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nav_profile) {
                    selectedFragment = new ProfileFragment();
                }else if (itemId == R.id.nav_cau1) {
                    selectedFragment = new Cau1Fragment();
                } else if (itemId == R.id.nav_cau2) {
                    selectedFragment = new Cau2Fragment();
                } else if (itemId == R.id.nav_cau3) {
                    selectedFragment = new Cau3Fragment();
                }  else if (itemId == R.id.nav_cau4) {
                    selectedFragment = new Cau4Fragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, selectedFragment).commit();

                return true;
            }
        });
    }
}