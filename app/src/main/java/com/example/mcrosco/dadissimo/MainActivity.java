package com.example.mcrosco.dadissimo;

import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements SensorEventListener {


    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private float lastAcc = 0.0f;
    private float acceleration = 0.0f;
    private float totAcc = 0.0f;
    private boolean onEvent = false;

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (!onEvent)
        {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            lastAcc= acceleration;
            acceleration= x*x+y*y+z*z;
            float diff = acceleration-lastAcc;
            totAcc= diff*acceleration;
            if (totAcc>15000){
                onEvent=true;
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setMessage("Reset?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener()

                {
                    @Override
                    public void onClick(DialogInterface sensor, int accuracy) {

                        onVisibleBehindCanceled();
                        onEvent=false;

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface sensor, int accuracy) {

                        onEvent=false;

                    }
                });

                builder.show();
            }

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        lastAcc=SensorManager.GRAVITY_EARTH;
        acceleration=SensorManager.GRAVITY_EARTH;

        {


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
}}