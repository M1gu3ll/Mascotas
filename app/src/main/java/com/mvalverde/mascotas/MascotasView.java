package com.mvalverde.mascotas;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MascotasView extends AppCompatActivity {

    ArrayList mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);
        setToolbar();
        fab();
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializaListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializaListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.dogdroopy, "Droopy", 0));
        mascotas.add(new Mascota(R.drawable.doghuesos, "Huesos", 0));
        mascotas.add(new Mascota(R.drawable.dogschnauzer, "Schnauzer", 0));
        mascotas.add(new Mascota(R.drawable.dogskwidd, "Skwidd", 0));
        mascotas.add(new Mascota(R.drawable.dogcoraje, "Coraje", 0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mascotas, menu);
        MenuItem register = menu.findItem(R.id.action_star);
        register.setVisible(true);
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
        } else if (id == R.id.action_star) {
            Intent intent = new Intent(this, MascotasFavoritasView.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void setToolbar() {
        Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar_mascota);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            miToolbar.setTitleTextColor(getResources().getColor(R.color.textColorPrimary, getTheme()));
        } else {
            miToolbar.setTitleTextColor(getResources().getColor(R.color.textColorPrimary));
        }
        miToolbar.setLogo(R.drawable.leg);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void fab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
