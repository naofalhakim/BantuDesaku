package com.example.user.bangundesaku.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.user.bangundesaku.R;
import com.example.user.bangundesaku.config.SessionLogin;

public class RegisterActivity extends AppCompatActivity {

    private EditText etNama, etInstansi, etEmail, etPassword, etNoKtp;
    private Button btnBuatAkun;
    private Spinner spUser, spIdNumber, spKelamin;
    private ArrayAdapter<CharSequence> myAdapter2;
    private SessionLogin sessionLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sessionLogin = new SessionLogin(RegisterActivity.this);

        etEmail = (EditText) findViewById(R.id.et_email_reg);
        etPassword = (EditText) findViewById(R.id.et_pass_reg);
        etInstansi = (EditText) findViewById(R.id.et_instansi);
        etNama = (EditText) findViewById(R.id.et_nama);
        etNoKtp = (EditText) findViewById(R.id.et_ktp);
        btnBuatAkun = (Button) findViewById(R.id.btn_register);
        spIdNumber = (Spinner) findViewById(R.id.sp_gambar);
        spKelamin = (Spinner) findViewById(R.id.sp_kelamin);
        spUser = (Spinner) findViewById(R.id.sp_user);

        myAdapter2= ArrayAdapter.createFromResource(RegisterActivity.this,R.array.kelamin,R.layout.desain_simple_spinner_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKelamin.setAdapter(myAdapter2);

        myAdapter2= ArrayAdapter.createFromResource(RegisterActivity.this,R.array.idCard,R.layout.desain_simple_spinner_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spIdNumber.setAdapter(myAdapter2);

        myAdapter2= ArrayAdapter.createFromResource(RegisterActivity.this,R.array.user,R.layout.desain_simple_spinner_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUser.setAdapter(myAdapter2);


        btnBuatAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionLogin.noteIntro(spUser.getSelectedItem().toString(),etEmail.getText().toString(),etNama.getText().toString(),spKelamin.getSelectedItem().toString());
                startActivity(new Intent(RegisterActivity.this,DoneRegActivity.class));
                finish();
            }
        });

    }
}
