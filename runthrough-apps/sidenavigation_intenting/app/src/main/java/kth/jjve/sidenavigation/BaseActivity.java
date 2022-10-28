package kth.jjve.sidenavigation;
/*
This app is created by Jitse van Esch for the @yeetivity youtube channel.
This app is for educational purposes only and gives an example on:
- Sidenavigations with drawerlayout
- Intenting

Last code review:
28-10-22
 */

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;


public class BaseActivity extends AppCompatActivity {

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //Apply custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Navigationview
        navigationView = findViewById(R.id.navigation_view);
        navigationView.bringToFront();

        //Create custom toggle to open side navigation
        DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Set action when item is selected
        navigationView.setNavigationItemSelectedListener(this::ClickListener);

    }

    @SuppressLint("NonConstantResourceId")
    private boolean ClickListener(MenuItem menuItem) {
        // Method to switch between different intents
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish(); //Back to home always clears backstack
                return true;
            case R.id.nav_results:
                startActivity(new Intent(getApplicationContext(), ResultsActivity.class));
                return true;
            case R.id.nav_settings:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                return true;
        }
        return false;
    }


}