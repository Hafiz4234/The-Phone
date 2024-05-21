package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class LengthConversion_page extends AppCompatActivity {
    EditText editTextValue;
    Spinner spinnerFromUnit, spinnerToUnit;
    Button buttonConvert;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lengthconversion_page);

        editTextValue = findViewById(R.id.editTextValue);
        spinnerFromUnit = findViewById(R.id.spinnerFromUnit);
        spinnerToUnit = findViewById(R.id.spinnerToUnit);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        // Populate spinners with units
        List<String> units = new ArrayList<>();
        units.add("Kilometer");
        units.add("Meter");
        units.add("Centimeter");
        units.add("Millimeter");
        units.add("Inch");
        units.add("Foot");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFromUnit.setAdapter(adapter);
        spinnerToUnit.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertLength();
            }
        });
    }

    private void convertLength() {
        String input = editTextValue.getText().toString().trim();
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input);
            double result = 0;

            // Conversion factors
            double[] conversionFactors = {1000, 1, 0.01, 0.001, 0.0254, 0.3048};
            int fromIndex = spinnerFromUnit.getSelectedItemPosition();
            int toIndex = spinnerToUnit.getSelectedItemPosition();

            result = value * conversionFactors[fromIndex] / conversionFactors[toIndex];

            textViewResult.setText(String.format("%.2f", result));
        } else {
            textViewResult.setText("Please enter a value.");
        }
    }
}