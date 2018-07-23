package com.example.user.bangundesaku.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.bangundesaku.R;

public class DoneLupaActivity extends AppCompatActivity {

    private Button btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_lupa);

        btnMasuk = (Button) findViewById(R.id.btn_masuk_resend);
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoneLupaActivity.this,PassswordActivity.class));
                finish();
            }
        });
    }
}
