package com.atacadogames.atacadoinfo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.atacadogames.atacadoinfo.Adapters.AdapterListConheceu;

import java.util.ArrayList;

public class PageEncontrou extends AppCompatActivity {

    ListView listView;
    AdapterListConheceu adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_encontrou);

        listView = (ListView) findViewById(R.id.ListViewEncontrou);


        //Cargando la lista de datos que sera adicionado en la ListView
        ArrayList<String> values =  new ArrayList<String>();
        values.add("Sim");
        values.add("Não");

        //Instanciando y cargando el adapter de la LitView
        adapterList  = new AdapterListConheceu(PageEncontrou.this,values);

        listView.setAdapter(adapterList);

        //Capturando la accion clic de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(PageEncontrou.this,PageComentario.class));
            }
        });
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
            startActivity(new Intent(PageEncontrou.this,PageRecomendar.class));
            finish();
        }else{
            if (id == R.id.previous) {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);

    }
}
