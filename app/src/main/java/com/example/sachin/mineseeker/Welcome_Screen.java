package com.example.sachin.mineseeker;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Welcome_Screen extends AppCompatActivity {

    ProgressBar loadingCircle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_creen);
        setupSkipButton();
        ImageView loadingImg = (ImageView)findViewById(R.id.loadingImg);
        Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.animation_welcome);
        loadingImg.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(Welcome_Screen.this,MainMenu.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void setupSkipButton() {
        Button button = (Button) findViewById(R.id.skip);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome_Screen.this,MainMenu.class);
                startActivity(intent);
                finish();

            }
        });
    }

}
