package com.example.e_learning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.android.material.navigation.NavigationView;

public class java_activity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout1;
    NavigationView navigationView;
    WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_activity);
        navigationView = findViewById(R.id.nav_draw_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout1 = findViewById(R.id.drawer_layout2);



        mywebview =(WebView) findViewById(R.id.webview);

        mywebview.loadUrl("https://www.w3schools.com/java/default.asp");


        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout1, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        drawerLayout1.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {


            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){

                int id = menuItem.getItemId();

                Intent i;

                switch (id) {

                    case R.id.java:
                        i = new Intent(java_activity.this, java_activity.class);
                        startActivity(i);
                        break;

                    case R.id.python:
                        i = new Intent(java_activity.this, python.class);
                        startActivity(i);
                        break;

                    case R.id.c_language:
                        i = new Intent(java_activity.this, Clanguage.class);
                        startActivity(i);
                        break;

                    case R.id.javascript:
                        i = new Intent(java_activity.this, javaScript.class);
                        startActivity(i);
                        break;
                }
                menuItem.setChecked(true);
                drawerLayout1.closeDrawers();
                return false;

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout1.isDrawerOpen(GravityCompat.START)){

            drawerLayout1.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
}
