package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class Arithmetic_page extends AppCompatActivity {

    EditText etFirst, etSecond;
    TextView tvAns;
    ShapeableImageView Plus, Minus, Multiply, Division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_page);

        etFirst = findViewById(R.id.etFirst);
        etSecond = findViewById(R.id.etSecond);
        tvAns = findViewById(R.id.tvAns);
        Plus = findViewById(R.id.imgplus);
        Minus = findViewById(R.id.imgMinus);
        Multiply = findViewById(R.id.imgMultiply);
        Division = findViewById(R.id.imgDivision);

        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });

        Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });
    }

    private void performOperation(String operator) {
        String firstStr = etFirst.getText().toString();
        String secondStr = etSecond.getText().toString();

        if (firstStr.isEmpty() || secondStr.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double first, second, ans = 0;

        try {
            first = Double.parseDouble(firstStr);
            second = Double.parseDouble(secondStr);

            switch (operator) {
                case "+":
                    ans = first + second;
                    tvAns.setText("Addition is: " + ans);
                    break;
                case "-":
                    ans = first - second;
                    tvAns.setText("Subtraction is: " + ans);
                    break;
                case "*":
                    ans = first * second;
                    tvAns.setText("Multiplication is: " + ans);
                    break;
                case "/":
                    if (second != 0) {
                        ans = first / second;
                        tvAns.setText("Division is: " + ans);
                    } else {
                        Toast.makeText(this, "Error: Division by zero", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }
}