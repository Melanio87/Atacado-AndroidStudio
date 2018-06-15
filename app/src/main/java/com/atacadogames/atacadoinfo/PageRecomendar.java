package com.atacadogames.atacadoinfo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.atacadogames.atacadoinfo.Adapters.AdapterRecomendation;

import java.util.ArrayList;

/**
 * @author Melanio
 * Ventana donde Seleccion de recomendacion de la loja. de 0 a 10.
 */
public class PageRecomendar extends Activity {
    //Variable que conforma la ventana
    GridView viewNums;
    AdapterRecomendation adapterRecomendation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_recomendar);

        //Instanciando la GridView que sera rellenado
        viewNums = (GridView) findViewById(R.id.gridViewListNum);

        //Lista de numeros enteros que rellenara la GridView de 0 a 10
        final ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 10; i >= 0;i-- ) {
            nums.add(i);
        }

        //Instanciando el adapter creado para rellenar la GridView,
        // parametros pasado El contex, el diseño para los cuadros,
        // y los valores a cargar.
        adapterRecomendation = new AdapterRecomendation(PageRecomendar.this,R.layout.grid_nums,nums);
        viewNums.setAdapter(adapterRecomendation);

        //Capturando el evento al clicar por los cuadros de la lista.
        viewNums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(PageRecomendar.this, String.valueOf(nums.get(position)), Toast.LENGTH_SHORT).show();
                //Llamando la pagina Avalie
                startActivity(new Intent(PageRecomendar.this,PageAvalie.class));
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
            startActivity(new Intent(PageRecomendar.this,PageRecomendar.class));
            finish();
        }else{
            if (id == R.id.previous) {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);

    }

}
