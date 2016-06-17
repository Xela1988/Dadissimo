package com.example.mcrosco.dadissimo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gli carico il fragment di selezione
        FragSelection fragSelection = new FragSelection();
        getSupportFragmentManager().beginTransaction().add(R.id.layout_main, fragSelection).addToBackStack(null).commit();



/*
        final Button throwbutton = (Button) findViewById(R.id.buttonThrow);
        final TextView viewtext4=(TextView) findViewById(R.id.d4);
       {
            @Override
            public void onClick(View v) {

            }
        });*/

    }
}