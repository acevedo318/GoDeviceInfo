package com.vladedesigners.godeviceinfo;

import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    List<String> valores = new ArrayList<>();
    Recursos res = new Recursos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        InicializarCabecera();
        Default(); //Default ListView

    }

    public void InicializarCabecera(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //con esto se genera el usuario en el header del menu
        View hView = navigationView.getHeaderView(0);
        TextView nombreDispositivo = (TextView) hView.findViewById(R.id.nombreDispositivo),subtitulo;
        nombreDispositivo.setText(Settings.Secure.getString(getContentResolver(), "bluetooth_name"));
        subtitulo = (TextView) hView.findViewById(R.id.Subtitulo);
        subtitulo.setText("");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        valores.clear();

        if (id == R.id.nav_android) {
            // Handle the camera action
            AbrirNavAndroid();

        } else if (id == R.id.nav_display) {

            AbrirNavDisplay();

        } else if (id == R.id.nav_cpu) {

            AbrirNavCPU();

        } else if (id == R.id.nav_gpu) {

            AbrirNavGPU();

        } else if (id == R.id.nav_memory) {

            AbrirNavMemory();

        }else if (id == R.id.nav_red) {

            AbrirNavNetwork();

        }else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        RecargarAdapter();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void Default(){
        valores.clear();
        AbrirNavAndroid();
        RecargarAdapter();

    }

    public void AbrirNavAndroid(){

        this.setTitle(R.string.nav_android);

        valores.clear();
        listView = (ListView)findViewById(R.id.listViewPrincipal);

        //Software
        valores.add(res.getString(R.string.SOFTWARE));

        valores.add(res.getString(R.string.AndroidVersion)+"\n " + Build.VERSION.RELEASE);
        valores.add(res.getString(R.string.APIversion)+"\n " + Build.VERSION.SDK_INT);
        valores.add(res.getString(R.string.CodeName)+"\n " + res.AndroidOSName());

        //Hardware
        valores.add(res.getString(R.string.hardware));

        valores.add(res.getString(R.string.Manufacturer)+"\n " + Build.MANUFACTURER);
        valores.add(res.getString(R.string.Model)+"\n " + Build.MODEL);
        valores.add(res.getString(R.string.Product)+"\n " + Build.PRODUCT);
        valores.add(res.getString(R.string.Board)+"\n " + Build.BOARD);



    }
    public void AbrirNavDisplay(){

        this.setTitle(R.string.nav_display);



    }

    public void AbrirNavCPU(){

        this.setTitle(R.string.nav_cpu);



    }

    public void AbrirNavGPU(){

        this.setTitle(R.string.nav_gpu);



    }


    public void AbrirNavMemory(){

        this.setTitle(R.string.nav_memory);



    }

    public void AbrirNavNetwork(){

        this.setTitle(R.string.nav_network);



    }


    public void RecargarAdapter(){

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,valores);
        listView.setAdapter(adapter);
    }

}
