package com.example.user.bangundesaku.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.bangundesaku.R;

public class LupaSandiActivity extends AppCompatActivity {

    private EditText et_email_lp;
    private Button btn_setulang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_sandi);

        et_email_lp= (EditText) findViewById(R.id.et_email_l);
        btn_setulang = (Button) findViewById(R.id.btn_kirim_sandi);

        btn_setulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LupaSandiActivity.this,DoneLupaActivity.class));
                finish();
            }
        });
    }
}
