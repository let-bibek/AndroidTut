package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class custom_toast extends AppCompatActivity {
    Button btnShowToast;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);


        btnShowToast = findViewById(R.id.btnShowToast);


        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = new Toast(getApplicationContext());
                View getToastView = getLayoutInflater()
                        .inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.toastViewGroup));
                toast.setView(getToastView);
                tvMessage = getToastView.findViewById(R.id.tvToastWarning);

                tvMessage.setText("Error occurred");

                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,-100);
                toast.show();
            }
        });

    }
}