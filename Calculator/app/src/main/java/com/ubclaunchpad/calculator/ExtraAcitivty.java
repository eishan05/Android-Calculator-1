package com.ubclaunchpad.calculator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExtraAcitivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_acitivty);
        Intent intent = getIntent();
        String extra = intent.getStringExtra("Extra");
        TextView text = (TextView) findViewById(R.id.TextUbc);

        switch (extra)
        {
            case "operation1":
                text.setText("UBC Rocks!");
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(
                        ObjectAnimator.ofFloat(text,"translationX",220f),
                        ObjectAnimator.ofFloat(text,"translationX",120f)
                );
                animatorSet.setDuration(1000);
                animatorSet.start();
                break;
            case "operation2":
                text.setText("UBC Launchpad!!");
                MediaPlayer yay = MediaPlayer.create(ExtraAcitivty.this,R.raw.yay);
                yay.start();
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(
                        ObjectAnimator.ofFloat(text,"translationX",40f),
                        ObjectAnimator.ofFloat(text,"rotation",1440)
                );
                animatorSet2.setDuration(2000);
                animatorSet2.start();
                break;
            case "operation3":
                text.setText("Thank you!!");
                MediaPlayer ring= MediaPlayer.create(ExtraAcitivty.this,R.raw.applause);
                ring.start();
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(
                        ObjectAnimator.ofFloat(text,"x",100f),
                        ObjectAnimator.ofFloat(text,"y",330f)
                );
                animatorSet3.setDuration(1000);
                animatorSet3.start();
                break;
        }
    }
}
