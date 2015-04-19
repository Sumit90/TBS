package com.project.tbs.tbs;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SplashActivity extends Activity {

    private static final int SPLASH_TIMEOUT=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent l_intent=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(l_intent);
                    SplashActivity.this.finish();

                }
            },SPLASH_TIMEOUT);


    }



}
