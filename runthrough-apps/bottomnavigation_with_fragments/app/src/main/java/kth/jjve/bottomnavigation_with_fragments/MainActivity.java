package kth.jjve.bottomnavigation_with_fragments;
/*
Example app created by Jitse van Esch for the @yeetivity youtubechannel.
App intended for educational purposes:
- creating bottom navigation
- switching using fragments

Last code review:
28-10-2022
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(this::listener);

        //Default fragment
        LoadFragment(new HomeFragment());
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
    }

    @SuppressLint("NonConstantResourceId")
    private boolean listener(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                //Load home fragment
                LoadFragment(new HomeFragment());
                return true;
            case R.id.nav_results:
                //Load results fragment
                LoadFragment(new ResultsFragment());
                return true;
            case R.id.nav_settings:
                //Load settings fragment
                LoadFragment(new SettingsFragment());
                return true;
        }
        return false;
    }

    private void LoadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_container, fragment, "");
        fragmentTransaction.commit();
    }
}