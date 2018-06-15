package com.atacadogames.atacadoinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page1 extends AppCompatActivity {
    Button btP2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        btP2 = (Button) findViewById(R.id.btP2);

        btP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p2 = new Intent().setClass(Page1.this,PageRecomendar.class);
                startActivity(p2);
            }
        });
    }
}
