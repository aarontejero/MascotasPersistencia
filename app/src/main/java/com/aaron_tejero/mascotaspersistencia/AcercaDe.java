package com.aaron_tejero.mascotaspersistencia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        ((TextView) findViewById(R.id.tbTitulo)).setText("Acerca de");
        ((ImageView)findViewById(R.id.iconoDer)).setVisibility(View.INVISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
