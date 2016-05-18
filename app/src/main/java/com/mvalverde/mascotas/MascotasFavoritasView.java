package com.mvalverde.mascotas;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MascotasFavoritasView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        setToolbar();
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
        mitoolbar.setLogo(R.drawable.dogleg);
        setSupportActionBar(mitoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
