package com.atacadogames.atacadoinfo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * @author Melanio
 * Ventana de Avaliaçao
 */
public class PageAvalie extends AppCompatActivity {
    //Declarar variables y objetos
    Button btAvancar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_avalie);

        //Instanciando el Boton Avancar
        btAvancar = (Button) findViewById(R.id.btAvancar);

        //Accion clic del botón
        btAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PageAvalie.this,PageConheceu.class));
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
                startActivity(new Intent(PageAvalie.this,PageRecomendar.class));
                finish();
            }else{
                if (id == R.id.previous) {
                    finish();
                }
            }
            return super.onOptionsItemSelected(item);

    }
}
