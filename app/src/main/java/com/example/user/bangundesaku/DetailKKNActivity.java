package com.example.user.bangundesaku;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.bangundesaku.menuuser.CariKKNActivity;

public class DetailKKNActivity extends AppCompatActivity {
    private ImageView imgKKN;
    private TextView txtTitle,txtDeskripsi;
    private Button btnSendRequest, btnSendSponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kkn);

        getSupportActionBar().setTitle("Cari Tempat KKN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgKKN = (ImageView) findViewById(R.id.img_kkn);
        txtTitle = (TextView) findViewById(R.id.txtx_title_kkn);
        txtDeskripsi = (TextView) findViewById(R.id.txtx_content_kkn);
        btnSendRequest = (Button) findViewById(R.id.btn_kirim_permintaan);
        btnSendSponsor = (Button) findViewById(R.id.btn_kirim_sponsor);

        Intent i = getIntent();

        imgKKN.setImageResource(i.getIntExtra("img",0));
        txtDeskripsi.setText(i.getStringExtra("konten"));
        txtTitle.setText(i.getStringExtra("judul"));
        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        btnSendSponsor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog2();
            }
        });
    }

    public void showDialog(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(DetailKKNActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_dialog_done, null);

        Button btnBack = (Button) mView.findViewById(R.id.btn_back_drawer);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                startActivity(new Intent(DetailKKNActivity.this,DrawerActivity.class));
                finish();
            }
        });

    }

    public void showDialog2(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(DetailKKNActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_dialog_done_sponsor, null);

        Button btnBack = (Button) mView.findViewById(R.id.btn_back_drawer);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                startActivity(new Intent(DetailKKNActivity.this,DrawerActivity.class));
                finish();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
