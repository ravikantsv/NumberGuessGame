package com.samatham.numberguessgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameScreen1 extends AppCompatActivity {
    private EditText editor;
    private TextView msgText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen1);
    }

    public void compareNum(View view) {
        editor = (EditText) findViewById(R.id.guessNum);

        int inputNum = Integer.valueOf(editor.getText().toString());
        String msgText1 = "You entered: " + String.valueOf(inputNum);

        msgText = (TextView) findViewById(R.id.tv_feedback);
        msgText.setText(msgText1);
    }
}
