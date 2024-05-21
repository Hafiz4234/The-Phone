package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.Manifest;

import com.google.android.material.imageview.ShapeableImageView;

public class Dialar_main extends AppCompatActivity {

    ShapeableImageView btncall;
    EditText etNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialar_main);

        btncall = findViewById(R.id.imgbtnCall);
        etNum = findViewById(R.id.etDialarid);

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_the_number();
            }
        });
    }

    private void call_the_number() {
        String number = etNum.getText().toString().trim();
        if(etNum.length()==11){
        if(ContextCompat.checkSelfPermission(Dialar_main.this, Manifest.permission.CALL_PHONE)!=
          PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Dialar_main.this, new String[]{Manifest.permission.CALL_PHONE},123);
        }
        else
        {
            if(number.length()>0)
            {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number));
                startActivity(i);
            }
            else
            {
                etNum.setError("Enter number!");
            }
        }
        }
        else{
            etNum.setError("Enter a Valid Number!");
        }
    }
}