package com.samatham.numberguessgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameScreen1 extends AppCompatActivity {
    private EditText editor;
    private TextView msgText;
    private int numGuess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen1);
        Random r = new Random();
        numGuess = (r.nextInt(10 - 1) + 1);
    }

    public void compareNum(View view) {
        editor = (EditText) findViewById(R.id.guessNum);

        int inputNum = Integer.valueOf(editor.getText().toString());
        String msgText2 = "System Guessed: " + String.valueOf(numGuess) + "\n";
        String msgText3 = "You Entered: " + String.valueOf(inputNum) + "\n";

        String msgText1;
        if(numGuess > inputNum){
            msgText1 = "You guessed a smaller number";
        }else if(numGuess < inputNum){
            msgText1 = "You guessed a larger number";
        }else {
            msgText1 = "CONGRATULATIONS - YOU ARE RIGHT";
            Intent intent = new Intent(GameScreen1.this, congratulation.class);
            startActivity(intent);
        }


        msgText = (TextView) findViewById(R.id.tv_feedback);
        msgText.setText(msgText1 + "\n" + msgText2 + msgText3);
    }
}
