package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction  fragmentTransaction = getSupportFragmentManager().beginTransaction();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        fragmentTransaction.replace(R.id.fragment_container,new Tab1Fragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.menu_tab1:
                        fragment = new Tab1Fragment();
                        break;
                    case R.id.menu_tab2:
                        fragment = new Tab2Fragment();
                        break;
                    case R.id.menu_tab3:
                        fragment = new Tab3Fragment();
                        break;
                    case R.id.menu_tab4:
                        fragment = new Tab4Fragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                return true;
            }
        });


    }
}