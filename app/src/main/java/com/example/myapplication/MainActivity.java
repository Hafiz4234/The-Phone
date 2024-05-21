package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView show_date = findViewById(R.id.tvDate);
        show_date.setText(date);


    }

    public void openTime_main(View view) {
        Intent intent = new Intent(this, Time_main.class);
        startActivity(intent);
    }

    public void openDate_main(View view) {
        Intent intent = new Intent(this, Calendar_main.class);
        startActivity(intent);
    }

    public void openDialar_main(View view) {
        Intent intent = new Intent(this, Dialar_main.class);
        startActivity(intent);
    }

    public void openMessage_main(View view) {
        Intent intent = new Intent(this, Message_main.class);
        startActivity(intent);
    }
    public void openCalculator_main_page(View view) {
        Intent intent = new Intent(this, Calculator_main_page.class);
        startActivity(intent);
    }


    public void openNote_main(View view) {
        Intent intent = new Intent(this, Note_main.class);
        startActivity(intent);
    }


    public void openGame_page(View view) {
        Intent intent = new Intent(this, Game_page.class);
        startActivity(intent);
    }
}