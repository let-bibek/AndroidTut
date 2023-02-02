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

        tvSensorOutput=findViewById(R.id.tvSensorOutput);
        tvSensorOutput.setText("");
        SensorManager sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        
        if (sensorManager!=null){
            Sensor acceleroSensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (acceleroSensor!=null){
                sensorManager.registerListener(this,acceleroSensor,SensorManager.SENSOR_DELAY_NORMAL);
            }else{
                Toast.makeText(this, "Sensor not detected", Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(this, "Sensor not detected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            tvSensorOutput.setText("X: "+event.values[0]+" Y: "+event.values[1]+" Z: "+event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}