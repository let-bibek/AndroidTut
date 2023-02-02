package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SensorEx extends AppCompatActivity implements SensorEventListener {
    TextView tvSensorOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_ex);

        tvSensorOutput = findViewById(R.id.tvSensorOutput);
        tvSensorOutput.setText("");
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null) {
            Sensor acceleroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            Sensor proxySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            // accelerometer
            if (acceleroSensor != null) {
                sensorManager.registerListener(this, acceleroSensor, SensorManager.SENSOR_DELAY_NORMAL);
            } else {
                Toast.makeText(this, "Sensor not detected", Toast.LENGTH_SHORT).show();

            }

            //proximity

            if (proxySensor != null) {
                sensorManager.registerListener(this, proxySensor, SensorManager.SENSOR_DELAY_NORMAL);
            }


        } else {
            Toast.makeText(this, "Sensor not detected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        //accelerometer
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            tvSensorOutput.setText("X: " + event.values[0] + " Y: " + event.values[1] + " Z: " + event.values[2]);
//            Toast.makeText(this, "X: " + event.values[0] + " Y: " + event.values[1] + " Z: " + event.values[2], Toast.LENGTH_SHORT).show();
        }

        //proximity

        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
//            tvSensorOutput.setText("Values: "+event.values[0]);


            if (event.values[0] > 0) {
                Toast.makeText(this, "Object is far", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Object is near", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}