package com.example.user.bangundesaku;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.bangundesaku.config.SessionLogin;
import com.example.user.bangundesaku.menufragment.BerandaFragment;
import com.example.user.bangundesaku.menufragment.PermintaanKKNFragment;
import com.example.user.bangundesaku.menufragment.PostingFragment;
import com.example.user.bangundesaku.menufragment.ProfileFragment;
import com.example.user.bangundesaku.menuuser.BantuDesaActivity;
import com.example.user.bangundesaku.menuuser.LaporanDesaActivity;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SessionLogin sessionLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sessionLogin = new SessionLogin(DrawerActivity.this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, new BerandaFragment()).commit();
        getSupportActionBar().setTitle("Ayo Bantu Desamu");
        
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(sessionLogin.getDataString(sessionLogin.KEY_JENISUSER).equals("Masyarakat")){
            navigationView.inflateMenu(R.menu.activity_drawer_drawer);
        }else{
            navigationView.inflateMenu(R.menu.activity_drawer_drawer_edit);
        }

        View root = navigationView.getHeaderView(0);
        TextView txtNama = (TextView) root.findViewById(R.id.txt_nama_nav);
        TextView txtEmail = (TextView) root.findViewById(R.id.txt_email_nav);
        ImageView imageView = (ImageView) root.findViewById(R.id.imageView);

        txtEmail.setText(sessionLogin.getDataString(sessionLogin.KEY_EMAILSUSER));
        txtNama.setText(sessionLogin.getDataString(sessionLogin.KEY_NAMAUSER));

        if(sessionLogin.getDataString(sessionLogin.KEY_KELAMINSUSER).equals("Laki-Laki")){
            imageView.setImageResource(R.drawable.avatar);
        }else {
            imageView.setImageResource(R.drawable.avatarcewek);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();

//        if (id == R.id.nav_posting) {
//            fragmentTransaction.replace(R.id.fragment_main, new PostingFragment());
//            getSupportActionBar().setTitle("Informasi Desa");
//        }
        if (id == R.id.nav_about) {

        }else if (id == R.id.nav_akun) {
            fragmentTransaction.replace(R.id.fragment_main, new ProfileFragment());
            getSupportActionBar().setTitle("Akun");
        }  else if (id == R.id.nav_bantuan) {

        } else if (id == R.id.nav_kebijakan) {

        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(DrawerActivity.this,StartedActivity.class));
            finish();
        } else if (id == R.id.nav_beranda) {
            fragmentTransaction.replace(R.id.fragment_main, new BerandaFragment());
            getSupportActionBar().setTitle("Ayo Bantu Desamu");
        }
        else if(id == R.id.nav_permintaan){
            fragmentTransaction.replace(R.id.fragment_main, new PermintaanKKNFragment());
            getSupportActionBar().setTitle("Permintaan KKN");
        }else if(id == R.id.nav_lapordesa){
            startActivity(new Intent(DrawerActivity.this, LaporanDesaActivity.class));
            return true;
        }else if(id == R.id.nav_bantudesa){
            startActivity(new Intent(DrawerActivity.this, BantuDesaActivity.class));
            return true;
        }
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
