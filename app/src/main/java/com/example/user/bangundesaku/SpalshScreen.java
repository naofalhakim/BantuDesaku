package com.example.user.bangundesaku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.user.bangundesaku.intro.IntroActivity;

public class SpalshScreen extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar =(ProgressBar) findViewById(R.id.progress);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        final Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    for (int i =0; i<100;i++){
                        sleep(40);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
        thread.start();
    }
}
