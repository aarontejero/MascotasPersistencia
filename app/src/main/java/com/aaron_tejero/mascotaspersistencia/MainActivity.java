package com.aaron_tejero.mascotaspersistencia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import com.aaron_tejero.mascotaspersistencia.Adapter.PageAdapter;
import com.aaron_tejero.mascotaspersistencia.Fragments.PerfilFragment;
import com.aaron_tejero.mascotaspersistencia.Fragments.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String perfilInstagram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        ((TextView) findViewById(R.id.tbTitulo)).setText("Pentagram");
        tabLayout=(TabLayout) findViewById(R.id.taabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        ObtenerPerfilShared();
        if(perfilInstagram.equals("")){
            crearPerfilShared();
        }

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

    }

    public void irFav(View v){
        Intent intent= new Intent(this,favoritos.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mnuContacto) {
            Intent intent = new Intent(MainActivity.this, Contacto.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.mnuAcercade) {
            Intent intent = new Intent(MainActivity.this, AcercaDe.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.mnuCuentaInstagram) {
            Intent intent = new Intent(MainActivity.this, ConfigurarCuentaInstagram.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFraagments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;

    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFraagments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_dogs);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_dogpark);
    }

    private void crearPerfilShared() {
        SharedPreferences perfilInstagram = getSharedPreferences("shared", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = perfilInstagram.edit();
        editor.putString("perfilInstagram", "atena_alana");
        editor.commit();
    }

    private void ObtenerPerfilShared(){
        SharedPreferences misReferencias = getSharedPreferences("shared", Context.MODE_PRIVATE);
        perfilInstagram = misReferencias.getString("perfilInstagram", "");
    }

}
