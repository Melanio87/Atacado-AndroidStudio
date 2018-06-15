package com.atacadogames.atacadoinfo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Principal extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btn = (Button) findViewById(R.id.btnEnviarInfo);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensageExibir("Evaluación Enviada!","GRACIAS POR SU PREFERENCIA!");
                Intent mainIntent = new Intent().setClass(
                        Principal.this, Page1.class);
                startActivity(mainIntent);
            }
        });
    }

    public void mensageExibir(String titulo, String texto) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Principal.this);
        builder.setTitle(titulo)
                .setMessage(texto)
                .setCancelable(false).setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //this for skip dialog
                        dialog.cancel();
                    }
                });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (alertDialog.isShowing()){
                    alertDialog.dismiss();
                }
            }
        }, 5000); //change 5000 with a specific time you want
    }
}
