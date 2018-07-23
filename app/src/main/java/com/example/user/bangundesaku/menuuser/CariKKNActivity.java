package com.example.user.bangundesaku.menuuser;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.bangundesaku.R;
import com.example.user.bangundesaku.adapter.DataKKNAdapter;
import com.example.user.bangundesaku.login.RegisterActivity;
import com.example.user.bangundesaku.model.RequestKKN;

import java.util.ArrayList;

public class CariKKNActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList arrayList;
    private LinearLayout linearLayout;
    private ArrayAdapter<CharSequence> myAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_kkn);

        getSupportActionBar().setTitle("Cari Tempat KKN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        arrayList = new ArrayList();
        arrayList.add(new RequestKKN("Desa Kutorjo","Nganjuk","Peningkatan perekonomian","Banyak potensi pertanian dan dan hasil kebun kurang bisa dijual dengan harga tinggi","Ekonomi",R.drawable.gb2));
        arrayList.add(new RequestKKN("Desa Banaran","Malang","Kebersihan pangan","Permasalahan sumber pangan kurang higenis karena kurangnya pengetahuan tentang pengolahan makanan","Kesehatan",R.drawable.gb1));
        arrayList.add(new RequestKKN("Desa Karangpatihan","Ponorogo","Banyak warga idiot di Desa Karangpatihan Balong Ponorogo","Ada beberapa penduduk, yang satu keluarganya mengalami keterbelakangan mental tersebut, seperti Ibu Giyem yang memiliki 4 saudara, dimana keempat-empatnya memiliki keterbelakangan mental. Begitu juga dengan seorang Ibu yang memiliki 2 orang anak yang cacat mental tersebut.\n","Pendidikan",R.drawable.gb3));
        arrayList.add(new RequestKKN("Desa Kutorjo","Banyuwangi","Peningkatan perekonomian","Banyak potensi pertanian dan dan hasil kebun kurang bisa dijual dengan harga tinggi","Ekonomi",R.drawable.gb2));

        recyclerView = (RecyclerView) findViewById(R.id.recycler_carikkn);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDoalog();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(CariKKNActivity.this));
        recyclerView.setAdapter(new DataKKNAdapter(CariKKNActivity.this,arrayList));

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

    public void showDoalog(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(CariKKNActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_dialog_filter, null);

        final Spinner spTopik = (Spinner) mView.findViewById(R.id.sp_topik);
        final Spinner spDaerah = (Spinner) mView.findViewById(R.id.sp_daerah);

        Button btnFilter = (Button) mView.findViewById(R.id.btn_filter_dialog);
        Button btnReset = (Button) mView.findViewById(R.id.btn_reset);

        myAdapter= ArrayAdapter.createFromResource(CariKKNActivity.this,R.array.topik,R.layout.support_simple_spinner_dropdown_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTopik.setAdapter(myAdapter);

        myAdapter = ArrayAdapter.createFromResource(CariKKNActivity.this,R.array.daerah,R.layout.support_simple_spinner_dropdown_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDaerah.setAdapter(myAdapter);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(CariKKNActivity.this,"Filtered",Toast.LENGTH_SHORT).show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spDaerah.setSelection(0);
                spTopik.setSelection(0);
            }
        });
    }
}
