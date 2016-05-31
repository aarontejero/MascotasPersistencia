package com.aaron_tejero.mascotaspersistencia;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Contacto extends AppCompatActivity {

    private TextInputEditText nombre;
    private TextInputEditText correo;
    private TextInputEditText mensaje;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar= (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        ((TextView) findViewById(R.id.tbTitulo)).setText("Contacto");
        ((ImageView)findViewById(R.id.iconoDer)).setVisibility(View.INVISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre=(TextInputEditText) findViewById(R.id.nombre);
        correo=(TextInputEditText) findViewById(R.id.correo);
        mensaje=(TextInputEditText) findViewById(R.id.mensaje);
        buttonSend=(Button) findViewById(R.id.btnEnviar);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

    }

    private void sendEmail() {
        //Getting content for email
        String email = correo.getText().toString().trim();
        String subject = nombre.getText().toString().trim();
        String message = mensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }



}
