package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class NumberGuessingGame extends AppCompatActivity {

    private int numberToGuess;
    private int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_guessing_game);

        final TextView instructions = findViewById(R.id.instructions);
        final EditText inputGuess = findViewById(R.id.input_guess);
        Button checkButton = findViewById(R.id.check_button);
        final TextView resultText = findViewById(R.id.result_text);

        resetGame();

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guessStr = inputGuess.getText().toString();
                if (guessStr.isEmpty()) {
                    Toast.makeText(NumberGuessingGame.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                int guess = Integer.parseInt(guessStr);
                attempts++;

                if (guess < numberToGuess) {
                    resultText.setText("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    resultText.setText("Too high! Try again.");
                } else {
                    resultText.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                    resetGame();
                }
            }
        });
    }

    private void resetGame() {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        attempts = 0;
    }
}