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
import android.widget.Button;
import android.widget.EditText;

import com.example.user.bangundesaku.DrawerActivity;
import com.example.user.bangundesaku.R;

public class LaporanDesaActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSubmit;
    private EditText etDokuemntasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_desa);

        getSupportActionBar().setTitle("Share Hasil Kegiatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSubmit=(Button) findViewById(R.id.btn_submit_laporkan);
        etDokuemntasi=(EditText) findViewById(R.id.et_dokumentasi);

        btnSubmit.setOnClickListener(this);
        etDokuemntasi.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return false;
        }
    }

    private void showDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(LaporanDesaActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_dialog_donelaporkan, null);

        Button btnBack = (Button) mView.findViewById(R.id.btn_back_drawer);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                startActivity(new Intent(LaporanDesaActivity.this,DrawerActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==btnSubmit){
            showDialog();
        }else{
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(gallery,0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri selectedImage = data.getData();
        String s= getRealPathFromURI(selectedImage);
        String name = s.substring(s.lastIndexOf("/") + 1);
        etDokuemntasi.setText(name);
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
