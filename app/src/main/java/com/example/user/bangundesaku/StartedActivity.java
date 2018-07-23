package com.example.user.bangundesaku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.bangundesaku.login.EmailActivity;
import com.example.user.bangundesaku.login.RegisterActivity;

public class StartedActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAyoMulai;
    private TextView txtbuatAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started);

        btnAyoMulai = (Button) findViewById(R.id.btn_ayomulai);
        txtbuatAkun = (TextView) findViewById(R.id.btn_buatakun);

        btnAyoMulai.setOnClickListener(this);
        txtbuatAkun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnAyoMulai){
            startActivity(new Intent(StartedActivity.this, EmailActivity.class));
            finish();
        }else{
            startActivity(new Intent(StartedActivity.this, RegisterActivity.class));
            finish();
        }
    }
}
