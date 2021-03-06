package com.samatham.numberguessgame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameScreen1 extends AppCompatActivity {
    private EditText editor;
    private TextView msgText;
    private int numGuess;
    public static final int ST_NUM = 1;
    public static final int LAST_NUM = 32;
    int upArrow = 0x23EB;
    int downArrow = 0x23EC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen1);
        Random r = new Random();
        numGuess = (r.nextInt(LAST_NUM - ST_NUM) + ST_NUM);
        msgText = (TextView) findViewById(R.id.tv_feedback);
        String msgDef = "Enter a Number between " + ST_NUM + " to " + LAST_NUM;
        msgText.setText(msgDef);
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    public void compareNum(View view) {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        editor = (EditText) findViewById(R.id.guessNum);
        msgText = (TextView) findViewById(R.id.tv_feedback);
//        String msgDef = "Enter a Number between " + ST_NUM + " to " + LAST_NUM;
//        msgText.setText(msgDef);
        int inputNum = Integer.valueOf(editor.getText().toString());
//        String msgText2 = "System Guessed: " + String.valueOf(numGuess) + "\n";
//        String msgText3 = "You Entered: " + String.valueOf(inputNum) + "\n";

        String msgText1;
        if(numGuess > inputNum){
//            msgText1 = "HIGHER ⬆️⬆️⬆️";
            msgText1 = "HIGHER " + getEmojiByUnicode(upArrow) + getEmojiByUnicode(upArrow)
            + getEmojiByUnicode(upArrow);
        }else if(numGuess < inputNum){
//            msgText1 = "SMALLER ⬇️⬇️⬇️";
            msgText1 = "SMALLER " + getEmojiByUnicode(downArrow) + getEmojiByUnicode(downArrow) +
            getEmojiByUnicode(downArrow);
        }else {
            msgText1 = "CONGRATULATIONS - YOU ARE RIGHT";
            Intent intent = new Intent(GameScreen1.this, congratulation.class);
            startActivity(intent);
        }
//        msgText.setText(msgText1 + "\n" + msgText2 + msgText3);
        msgText.setText(msgText1);
    }
}
