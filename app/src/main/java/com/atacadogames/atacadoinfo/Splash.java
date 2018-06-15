package com.atacadogames.atacadoinfo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Melanio
 * Pantalla de presentación
 */
public class Splash extends AppCompatActivity {
    private static final long SPLASH_SCREEN_DELAY = 3500;
    Display display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Optener el ancho y alto de la pantalla
        display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int ancho= display.getWidth();
        int alto= display.getHeight();

        if(ancho > alto){
            //Orientacionde Pantalla Horizontal
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else{
            //Orientacionde Pantalla Vertical
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        // Ocultar Barra de Titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Iniciar Siguiente actividad
                Intent mainIntent = new Intent().setClass(
                        Splash.this, PageRecomendar.class);
                startActivity(mainIntent);

                // Cerrar la actividad por lo que el usuario no será capaz de volver a ella pulsando el botón Atrás.
                finish();
            }
        };

        // Simular un proceso de carga largo al iniciar la aplicación.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
