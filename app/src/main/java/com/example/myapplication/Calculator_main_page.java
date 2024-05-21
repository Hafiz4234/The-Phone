package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Calculator_main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main_page);
    }

    public void openArithmetic_main_page(View view) {
        Intent intent = new Intent(this, Arithmetic_page.class);
                startActivity(intent);
    }

    public void openTempConversion_page(View view) {
        Intent intent = new Intent(this, TempConversion_page.class);
        startActivity(intent);
    }

    public void openLenghtConversion(View view) {
        Intent intent = new Intent(this, LengthConversion_page.class);
        startActivity(intent);

        }

    }
