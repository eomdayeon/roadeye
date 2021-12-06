package com.example.roadeye_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayDeque;
import java.util.Deque;

public class MapActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;

    private MainMapFragment mainMapFragment;
    private MypageFragment mypageFragment;
    private VideoFragment videoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bn_main_map:
                        setFrag(0);
                        break;
                    case R.id.bn_video_map:
                        setFrag(1);
                        break;
                    case R.id.bn_mypage:
                        setFrag(2);
                        break;
                }

            }
        });
        mainMapFragment =new MainMapFragment();
        mypageFragment = new MypageFragment();
        videoFragment = new VideoFragment();

        setFrag(0);

    }

    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.fragment, mainMapFragment);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.fragment, videoFragment);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.fragment, mypageFragment);
                ft.commit();
                break;
        }
    }

}