package com.samatham.numberguessgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class congratulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);
    }

    public void playAgain(View view) {
        Intent intent = new Intent(this, GameScreen1.class);
        startActivity(intent);
    }
}
