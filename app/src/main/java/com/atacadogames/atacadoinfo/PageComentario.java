package com.atacadogames.atacadoinfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.atacadogames.atacadoinfo.Util.BrPhoneNumberFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PageComentario extends AppCompatActivity {

    EditText phoneNumber;
    Button btFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_comentario);

        phoneNumber = (EditText) findViewById(R.id.etPhone);
        btFinalizar = (Button) findViewById(R.id.btFinalizar);

        BrPhoneNumberFormatter addLineNumberFormatter = new BrPhoneNumberFormatter(new WeakReference<EditText>(phoneNumber));
        phoneNumber.addTextChangedListener(addLineNumberFormatter);

        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensageExibir("Avaliação Enviada!","Obrigado!");

            }
        });


    }

    public void mensageExibir(String titulo, String texto) {
        AlertDialog.Builder builder = new AlertDialog.Builder(PageComentario.this);
        builder.setTitle(titulo)
                .setMessage(texto)
                .setCancelable(false).setCancelable(false)/*
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //this for skip dialog
                        dialog.cancel();
                    }
                })*/;
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (alertDialog.isShowing()){
                    alertDialog.dismiss();
                    startActivity(new Intent(PageComentario.this,PageRecomendar.class));
                    finish();
                }
            }
        }, 3000); //change 5000 with a specific time you want
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.cancel) {
            startActivity(new Intent(PageComentario.this,PageRecomendar.class));
            finish();
        }else{
            if (id == R.id.previous) {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);

    }


    //Clase que enviará la respuesta al servidor
    public class EnviarEncuesta extends AsyncTask<Void, Integer, String> {
        ProgressDialog dialog;

        @Override
        protected void onProgressUpdate(Integer... values) {
        }

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(PageComentario.this, "", "Enviando...", true);
        }

        @Override
        protected String doInBackground(Void... params) {
            String result = null;
            InputStream inputStream = null;
            try {
                HttpParams httpParameters = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(httpParameters, 50000);
                HttpClient httpClient = new DefaultHttpClient();

                HttpPost post = new HttpPost("http://www.atacadogames.com/");
                try {

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("nombre","Melanio Valdez");

                    String json;
                    json=jsonObject.toString();

                    StringEntity se = new StringEntity(json);

                    post.setEntity(se);

                    post.setHeader("Accept", "application/json");
                    post.setHeader("Content-type", "application/json");

                    HttpResponse httpResponse = httpClient.execute(post);

                    result = EntityUtils.toString(httpResponse.getEntity());
                    if (!result.equalsIgnoreCase("")) {
                        Log.i("Aviso", result);
                    }

                } catch (Exception ex) {
                    Log.e("ServicioRest", "Error!", ex);
                }

            } catch (Exception ex) {
                Log.i("Error", "Error al guardar posicion en bd " + ex.getMessage());
            }

            return result;
        }


        @Override
        protected void onPostExecute(String result) {
            // async task finalizado
            dialog.dismiss();
            //   Log.v("Progreso", "Finalizado "+result);
            if (!result.trim().equalsIgnoreCase("")) {
               Log.i("Resultado", result);
            }
        }
    }
}
