package com.example.user.bangundesaku.menuuser;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.user.bangundesaku.DetailKKNActivity;
import com.example.user.bangundesaku.DrawerActivity;
import com.example.user.bangundesaku.R;
import com.example.user.bangundesaku.model.RequestKKN;

import java.util.ArrayList;

public class BantuDesaActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etNamaDesa, etNamaDaerah, etTglM, etTglA, etGambar;
    private Spinner spinner;
    private ArrayAdapter<CharSequence> requestKKNS;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantu_desa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bantu Desa");

        spinner = (Spinner) findViewById(R.id.sp_sponsor);
        etTglM = (EditText) findViewById(R.id.et_tanggal_m);
        etTglA = (EditText) findViewById(R.id.et_tanggal_a);
        etGambar = (EditText) findViewById(R.id.et_gambar);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        requestKKNS = ArrayAdapter.createFromResource(BantuDesaActivity.this,R.array.sponsjor,R.layout.support_simple_spinner_dropdown_item);
        requestKKNS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(requestKKNS);

        etTglA.setOnClickListener(this);
        etTglM.setOnClickListener(this);
        etGambar.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if(v==etTglA){

        }else if(v==etTglM){

        }else if(v==btnSubmit){
            showDialog();
        }else{
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(gallery,0);
        }
    }

    private void showDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(BantuDesaActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_dialogbantuan_done, null);

        Button btnBack = (Button) mView.findViewById(R.id.btn_back_drawer);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                startActivity(new Intent(BantuDesaActivity.this,DrawerActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri selectedImage = data.getData();
        String s= getRealPathFromURI(selectedImage);
        String name = s.substring(s.lastIndexOf("/") + 1);
        etGambar.setText(name);
    }

    public String getRealPathFromURI(Uri contentUri) {

        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery( contentUri,
                proj, // Which columns to return
                null, // WHERE clause; which rows to return (all rows)
                null, // WHERE clause selection arguments (none)
                null); // Order-by clause (ascending by name)
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
