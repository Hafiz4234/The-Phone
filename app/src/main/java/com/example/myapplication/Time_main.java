package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Time_main extends AppCompatActivity implements View.OnClickListener{

    private TimePicker tp;
    private Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_main);
        btnSet = findViewById(R.id.set_alarm);
        tp = findViewById(R.id.time_time);
        btnSet.setOnClickListener(this);


    }

    @Override
    public void onClick(View view)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
        cal.get(Calendar.MONTH),
        cal.get(Calendar.DAY_OF_MONTH),
        tp.getHour(),
        tp.getMinute(),0);
        set_alarm(cal.getTimeInMillis());
    }

    private void set_alarm(long timeInMillis)
    {
        AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(this,"Alarm is Set",Toast.LENGTH_LONG).show();
    }


    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}