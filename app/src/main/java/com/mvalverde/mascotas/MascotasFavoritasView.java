package com.mvalverde.mascotas;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;

public class MascotasFavoritasView extends AppCompatActivity {

    ArrayList mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        setToolbar();
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializaListaMascotas();
        inicializarAdaptador();
    }

    public void inicializaListaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.dogskwidd, "Skwidd", 0));
        mascotas.add(new Mascota(R.drawable.dogcoraje, "Coraje", 0));
        mascotas.add(new Mascota(R.drawable.dogschnauzer, "Schnauzer", 0));
        mascotas.add(new Mascota(R.drawable.dogdroopy, "Droopy", 0));
        mascotas.add(new Mascota(R.drawable.doghuesos, "Huesos", 0));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mascotas, menu);
        return true;
    }

    private void setToolbar() {
        Toolbar mitoolbar = (Toolbar) findViewById(R.id.miActionBar_favorito);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mitoolbar.setTitleTextColor(getResources().getColor(R.color.textColorPrimary, getTheme()));
        } else {
            mitoolbar.setTitleTextColor(getResources().getColor(R.color.textColorPrimary));
        }
        mitoolbar.setLogo(R.drawable.leg);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
