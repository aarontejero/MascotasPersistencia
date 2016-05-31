package com.aaron_tejero.mascotaspersistencia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.aaron_tejero.mascotaspersistencia.Adapter.FavoritosAdapter;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.presentador.FavoritosPresenter;
import com.aaron_tejero.mascotaspersistencia.presentador.IFavoritosPresenter;

public class favoritos extends AppCompatActivity  {
    private RecyclerView recycler;
    ArrayList<Mascota> mascotas;
    private IFavoritosPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        ((TextView) findViewById(R.id.tbTitulo)).setText("Favoritos");
        ((ImageView)findViewById(R.id.iconoDer)).setVisibility(View.INVISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler=(RecyclerView) findViewById(R.id.recicladorFav);
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);

        presenter=new FavoritosPresenter(this,getBaseContext());
        mascotas=presenter.getLista();

        inicializarAdaptadorRV();

    }


   public void inicializarAdaptadorRV() {
       FavoritosAdapter adaptador= new FavoritosAdapter(mascotas,this);
       recycler.setAdapter(adaptador);
    }
}
