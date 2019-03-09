package com.example.ambit.mobilepolice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class AboutDevelopers extends AppCompatActivity {

    LinearLayout imtiazDeveloper, afifaDeveloper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developers);

        imtiazDeveloper =  findViewById(R.id.imtiazDeveloper);
        afifaDeveloper =  findViewById(R.id.afifaDeveloper);

        Animation animation  = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        imtiazDeveloper.startAnimation(animation);

        Animation animation2  = AnimationUtils.loadAnimation(this, R.anim.righttoleft);
        afifaDeveloper.startAnimation(animation2);
    }
}
