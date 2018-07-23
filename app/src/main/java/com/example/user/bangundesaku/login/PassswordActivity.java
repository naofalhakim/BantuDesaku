package com.example.user.bangundesaku.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.bangundesaku.DrawerActivity;
import com.example.user.bangundesaku.R;

public class PassswordActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_masuk, btn_lupa;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passsword);

        btn_lupa = (Button) findViewById(R.id.btn_lupa);
        btn_masuk = (Button) findViewById(R.id.btn_masuk);

        et_password = (EditText) findViewById(R.id.et_passwrod);

        btn_masuk.setOnClickListener(this);
        btn_lupa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn_lupa){
            startActivity(new Intent(PassswordActivity.this, LupaSandiActivity.class));
        }else{
            startActivity(new Intent(PassswordActivity.this, DrawerActivity.class));
        }
    }
}
