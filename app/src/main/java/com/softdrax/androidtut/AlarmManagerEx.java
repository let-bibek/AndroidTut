package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlarmManagerEx extends AppCompatActivity {
    EditText etAlarmTime;
    Button btnStartAlarm;
    static final int ALARM_REQUEST_CODE = 88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager_ex);

        etAlarmTime = findViewById(R.id.etAlarmTime);
        btnStartAlarm = findViewById(R.id.btnSetAlarm);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent iBroadcast=new Intent(AlarmManagerEx.this,AlarmBroadCastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmManagerEx.this, ALARM_REQUEST_CODE,iBroadcast,PendingIntent.FLAG_UPDATE_CURRENT);

        btnStartAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(((EditText) etAlarmTime).getText().toString());

                long AlarmTriggerTime = System.currentTimeMillis() + (time * 1000);

                alarmManager.set(AlarmManager.RTC_WAKEUP, AlarmTriggerTime, pendingIntent);

            }
        });

        findViewById(R.id.btnStopAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager.cancel(pendingIntent);
            }
        });
    }
}