package com.ubclaunchpad.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        display = (TextView) findViewById(R.id.answer);
        Intent intent = getIntent();
        String answer = intent.getStringExtra("Extra");
        display.setText(answer);


    }
}
