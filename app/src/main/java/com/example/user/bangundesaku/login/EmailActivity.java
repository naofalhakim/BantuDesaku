package com.example.user.bangundesaku.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.bangundesaku.R;

public class EmailActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        editText = (EditText) findViewById(R.id.et_email);
        btn_email = (Button) findViewById(R.id.btn_email);

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmailActivity.this,PassswordActivity.class));
            }
        });
    }
}
