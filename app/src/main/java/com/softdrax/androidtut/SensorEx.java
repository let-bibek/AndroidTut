package com.softdrax.androidtut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class SensorEx extends AppCompatActivity implements SensorEventListener {
    TextView tvSensorOutput;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_ex);

        tvSensorOutput = findViewById(R.id.tvSensorOutput);
        constraintLayout = findViewById(R.id.layoutSensors);


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


        // biometric


        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(this, "This device doesn't have fingerprint sensor", Toast.LENGTH_SHORT).show();

            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(this, "Fingerprint busy", Toast.LENGTH_SHORT).show();

            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(this, "No fingerprint is added yet", Toast.LENGTH_SHORT).show();
        }

        Executor executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(SensorEx.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(SensorEx.this, "Login Success", Toast.LENGTH_SHORT).show();
                constraintLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo
                .Builder()
                .setTitle("Use Fingerprint to login")
                .setDescription("Use Fingerprint to login")
                .setDeviceCredentialAllowed(true)
                .build();

        biometricPrompt.authenticate(promptInfo);


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