package com.aaron_tejero.mascotaspersistencia;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfigurarCuentaInstagram extends AppCompatActivity {
    private Button btnGuardarCuenta;
    private TextInputEditText txtUsuario;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta_instagram);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        ((TextView) findViewById(R.id.tbTitulo)).setText("Contacto");
        ((ImageView)findViewById(R.id.iconoDer)).setVisibility(View.INVISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            txtUsuario = (TextInputEditText) findViewById(R.id.tvUsuarioconfig);
            btnGuardarCuenta = (Button) findViewById(R.id.btnGuardarCuenta);
            btnGuardarCuenta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GuardarCuenta();
                }
            });
    }



    private void GuardarCuenta() {
        String usuario = txtUsuario.getText().toString().trim();
        if(ValidaCampo(usuario)){
            SharedPreferences perfilInstagram = getSharedPreferences("shared", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = perfilInstagram.edit();
            editor.putString("perfilInstagram", usuario);
            editor.commit();

            Toast.makeText(this, "La cuenta se guardó correctamente", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "REGRESE AL PERFIL PARA VER LOS CAMBIOS", Toast.LENGTH_LONG).show();
        }
        else{
            txtUsuario.setError("Ingrese una cuenta de usario");
        }

    }

    private boolean ValidaCampo(String usuario) {
        if(usuario.isEmpty() || usuario == null || usuario.length() == 0)
            return false;
        else
            return true;
    }
}
