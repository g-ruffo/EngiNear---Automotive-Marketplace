package com.veltus.enginear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.veltus.enginear.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSupportActionBar(binding.toolbar);

        drawerLayout = binding.drawerLayout;

        /* Create rotating hamburger menu icon on ToolBar */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CraigslistFragment()).addToBackStack(null).commit();


        if(savedInstanceState == null) {

            /* Create an OnNavigationItemSelectedListener for the nav_view NavigationView */
            navigationView = binding.navView;
            navigationView.setNavigationItemSelectedListener(this);
        }

        /* Set the first fragment selected in the navigation drawer */
        navigationView.setCheckedItem(R.id.nav_craigslist);




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        /* Check the selected resource item ID and replace the current fragment_container with the correct corresponding page fragment */
        switch (item.getItemId()) {
            case R.id.nav_search_all:
                break;

            case R.id.nav_craigslist:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CraigslistFragment()).addToBackStack(null).commit();
                break;

            case R.id.nav_facebook_marketplace:
                break;

            case R.id.nav_craigslist_settings:

                break;
            case R.id.nav_facebook_settings:

                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        /* Check to see if Drawer is open and if true close drawer on back press */
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            /* If Drawer is not open and the back button is pressed, close activity as normal */
            super.onBackPressed();
        }
    }

}