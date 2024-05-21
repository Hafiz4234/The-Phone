package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class RockPaperScissors extends AppCompatActivity {

    private String[] choices = {"Rock", "Paper", "Scissors"};
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        final TextView resultText = findViewById(R.id.result_text);
        Button rockButton = findViewById(R.id.rock_button);
        Button paperButton = findViewById(R.id.paper_button);
        Button scissorsButton = findViewById(R.id.scissors_button);

        random = new Random();

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Rock", resultText);
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Paper", resultText);
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Scissors", resultText);
            }
        });
    }

    private void playGame(String userChoice, TextView resultText) {
        String computerChoice = choices[random.nextInt(choices.length)];
        String result;

        if (userChoice.equals(computerChoice)) {
            result = "It's a tie! Computer chose " + computerChoice + ".";
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            result = "You win! Computer chose " + computerChoice + ".";
        } else {
            result = "You lose! Computer chose " + computerChoice + ".";
        }

        resultText.setText(result);
    }
}