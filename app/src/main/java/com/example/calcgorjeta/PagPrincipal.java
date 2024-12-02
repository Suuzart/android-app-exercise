package com.example.calcgorjeta;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class PagPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    Dialog log_pop;
    Button btt_pop_con, btt_pop_can;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_princ);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, FragMesas.class,null).commit();
            navigationView.setCheckedItem(R.id.nav_mesas);
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abrir, R.string.fechar);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        log_pop = new Dialog(PagPrincipal.this);
        log_pop.setContentView(R.layout.logout_popup);
        Objects.requireNonNull(log_pop.getWindow()).setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        log_pop.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.log_pop_bg));
        log_pop.setCancelable(false);

        btt_pop_con = log_pop.findViewById(R.id.confirm_logout);
        btt_pop_can = log_pop.findViewById(R.id.cancel_logout);

        btt_pop_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                log_pop.dismiss();
            }
        });

        btt_pop_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                log_pop.dismiss();
                Toast.makeText(PagPrincipal.this, "Aplicativo encerrado", Toast.LENGTH_SHORT).show();
                System.exit(1);
            }
        });

        OnBackPressedCallback drawerCallback = new OnBackPressedCallback(false) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
            }
        };
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                drawerCallback.setEnabled(false);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                drawerCallback.setEnabled(true);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, drawerCallback);

    }

    public void abreMenu(){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_mesas)
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, FragMesas.class,null).commit();

        else if (item.getItemId() == R.id.nav_cardapio)
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, FragCardapio.class,null).commit();

        else if (item.getItemId() == R.id.nav_logout)
            log_pop.show();

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}