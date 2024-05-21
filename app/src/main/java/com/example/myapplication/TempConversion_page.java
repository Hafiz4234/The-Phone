package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TempConversion_page extends AppCompatActivity {

    private EditText editTextCelsius, editTextFahrenheit, editTextKelvin;
    private TextView textViewCelsiusResult, textViewFahrenheitResult, textViewKelvinResult;
    private Button buttonConvertToFahrenheitFromCelsius, buttonConvertToKelvinFromCelsius,
            buttonConvertToCelsiusFromFahrenheit, buttonConvertToKelvinFromFahrenheit,
            buttonConvertToCelsiusFromKelvin, buttonConvertToFahrenheitFromKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempconversion_page);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        editTextKelvin = findViewById(R.id.editTextKelvin);
        textViewCelsiusResult = findViewById(R.id.textViewCelsiusResult);
        textViewFahrenheitResult = findViewById(R.id.textViewFahrenheitResult);
        textViewKelvinResult = findViewById(R.id.textViewKelvinResult);
        buttonConvertToFahrenheitFromCelsius = findViewById(R.id.buttonConvertToFahrenheitFromCelsius);
        buttonConvertToKelvinFromCelsius = findViewById(R.id.buttonConvertToKelvinFromCelsius);
        buttonConvertToCelsiusFromFahrenheit = findViewById(R.id.buttonConvertToCelsiusFromFahrenheit);
        buttonConvertToKelvinFromFahrenheit = findViewById(R.id.buttonConvertToKelvinFromFahrenheit);
        buttonConvertToCelsiusFromKelvin = findViewById(R.id.buttonConvertToCelsiusFromKelvin);
        buttonConvertToFahrenheitFromKelvin = findViewById(R.id.buttonConvertToFahrenheitFromKelvin);

        buttonConvertToFahrenheitFromCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCelsiusToFahrenheit();
            }
        });

        buttonConvertToKelvinFromCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCelsiusToKelvin();
            }
        });

        buttonConvertToCelsiusFromFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFahrenheitToCelsius();
            }
        });

        buttonConvertToKelvinFromFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFahrenheitToKelvin();
            }
        });

        buttonConvertToCelsiusFromKelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertKelvinToCelsius();
            }
        });

        buttonConvertToFahrenheitFromKelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertKelvinToFahrenheit();
            }
        });
    }

    private void convertCelsiusToFahrenheit() {
        String celsiusString = editTextCelsius.getText().toString();
        if (!celsiusString.isEmpty()) {
            double celsius = Double.parseDouble(celsiusString);
            double fahrenheit = (celsius * 9/5) + 32;
            textViewCelsiusResult.setText(String.format("Result: %.2f °F", fahrenheit));
        } else {
            textViewCelsiusResult.setText("Enter a value");
        }
    }

    private void convertCelsiusToKelvin() {
        String celsiusString = editTextCelsius.getText().toString();
        if (!celsiusString.isEmpty()) {
            double celsius = Double.parseDouble(celsiusString);
            double kelvin = celsius + 273.15;
            textViewCelsiusResult.setText(String.format("Result: %.2f K", kelvin));
        } else {
            textViewCelsiusResult.setText("Enter a value");
        }
    }

    private void convertFahrenheitToCelsius() {
        String fahrenheitString = editTextFahrenheit.getText().toString();
        if (!fahrenheitString.isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitString);
            double celsius = (fahrenheit - 32) * 5/9;
            textViewFahrenheitResult.setText(String.format("Result: %.2f °C", celsius));
        } else {
            textViewFahrenheitResult.setText("Enter a value");
        }
    }

    private void convertFahrenheitToKelvin() {
        String fahrenheitString = editTextFahrenheit.getText().toString();
        if (!fahrenheitString.isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitString);
            double kelvin = (fahrenheit - 32) * 5/9 + 273.15;
            textViewFahrenheitResult.setText(String.format("Result: %.2f K", kelvin));
        } else {
            textViewFahrenheitResult.setText("Enter a value");
        }
    }

    private void convertKelvinToCelsius() {
        String kelvinString = editTextKelvin.getText().toString();
        if (!kelvinString.isEmpty()) {
            double kelvin = Double.parseDouble(kelvinString);
            double celsius = kelvin - 273.15;
            textViewKelvinResult.setText(String.format("Result: %.2f °C", celsius));
        } else {
            textViewKelvinResult.setText("Enter a value");
        }
    }

    private void convertKelvinToFahrenheit() {
        String kelvinString = editTextKelvin.getText().toString();
        if (!kelvinString.isEmpty()) {
            double kelvin = Double.parseDouble(kelvinString);
            double fahrenheit = (kelvin - 273.15) * 9/5 + 32;
            textViewKelvinResult.setText(String.format("Result: %.2f °F", fahrenheit));
        } else {
            textViewKelvinResult.setText("Enter a value");
        }
    }
}
