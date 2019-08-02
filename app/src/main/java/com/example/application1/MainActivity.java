package com.example.application1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(nav_listener);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new Fragment1()).addToBackStack(null).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav_listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Fragment selecteed = null;

            switch (item.getItemId()){

                case R.id.menu1:
                    selecteed = new Fragment1();
                    break;
                case R.id.menu2:
                    selecteed = new Fragment2();
                    break;
                case R.id.menu3:
                    selecteed = new Fragment3();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selecteed).addToBackStack(null).commit();

            return true;
        }
    };

}
