package com.example.sachin.mineseeker;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Welcome_Screen extends AppCompatActivity {

    ProgressBar loadingCircle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_creen);
        ImageView loadingImg = (ImageView)findViewById(R.id.loadingImg);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation_welcome);

        loadingImg.setAnimation(animation);

        loadingCircle = (ProgressBar) findViewById(R.id.loadingProgressBar);
        ObjectAnimator objAnim  = ObjectAnimator.ofInt(loadingCircle,"Loading",0,2000);
        objAnim.setDuration(3000);
        objAnim.setInterpolator(new DecelerateInterpolator());
        objAnim.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(Welcome_Screen.this,MainMenu.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }

}
