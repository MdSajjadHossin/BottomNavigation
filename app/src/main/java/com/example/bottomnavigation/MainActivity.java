package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavView = findViewById(R.id.bottomNav);

        bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.home){
                    loadFragment(new HomeFragment(),0);
                }else if(id == R.id.search){
                    loadFragment(new SearchFragment(),0);
                }else if(id == R.id.utilities){
                    loadFragment(new UtilitiesFragment(),0);
                }else if(id == R.id.contact){
                    loadFragment(new ContactFragment(),0);
                }else{ // profile
                    loadFragment(new ProfileFragment(), 1);
                }

                return false;
            }
        });
        bottomNavView.setSelectedItemId(R.id.profile);
    }

    public void loadFragment(Fragment fragment, int flag){
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag == 1)
            ft.add(R.id.container, fragment);
        else
            ft.replace(R.id.container, fragment);

        ft.commit();
    }

}