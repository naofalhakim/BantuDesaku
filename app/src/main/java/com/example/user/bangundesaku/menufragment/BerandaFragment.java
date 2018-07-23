package com.example.user.bangundesaku.menufragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.user.bangundesaku.R;
import com.example.user.bangundesaku.config.SessionLogin;
import com.example.user.bangundesaku.menuuser.BantuDesaActivity;
import com.example.user.bangundesaku.menuuser.CariKKNActivity;
import com.example.user.bangundesaku.menuuser.LaporanDesaActivity;
import com.example.user.bangundesaku.menuuser.PantauActivity;


public class BerandaFragment extends Fragment implements View.OnClickListener{

    public BerandaFragment() {
        // Required empty public constructor
    }
    private ImageButton btnCariKKN, btnLaporDesa, btnPantau, btnBantuDesa;
    private SessionLogin sessionLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_beranda, container, false);

        btnCariKKN = (ImageButton) v.findViewById(R.id.btn_cariKKN);
//        btnLaporDesa = (ImageButton) v.findViewById(R.id.btn_lapordesamu);
        btnPantau = (ImageButton) v.findViewById(R.id.btn_pantau);
        btnBantuDesa = (ImageButton) v.findViewById(R.id.btn_bantuDesa);

        sessionLogin = new SessionLogin(getContext());
        String sessionLevel = sessionLogin.getDataString(sessionLogin.KEY_JENISUSER);
        configHidingButton(sessionLevel);

        btnBantuDesa.setOnClickListener(BerandaFragment.this);
//        btnLaporDesa.setOnClickListener(BerandaFragment.this);
        btnPantau.setOnClickListener(BerandaFragment.this);
        btnCariKKN.setOnClickListener(BerandaFragment.this);

        return v;
    }


    @Override
    public void onClick(View v) {
        if(btnCariKKN  == v){
            startActivity(new Intent(getContext(), CariKKNActivity.class));
        }else if(btnPantau==v){
            startActivity(new Intent(getContext(), PantauActivity.class));
        }else if(btnLaporDesa == v){

        }else if(btnBantuDesa == v){
            startActivity(new Intent(getContext(), BantuDesaActivity.class));
        }
    }

    private void configHidingButton(String sessionLevel) {
        if(sessionLevel.equals("Masyarakat")){
            btnCariKKN.setVisibility(View.VISIBLE);
//            btnBantuDesa.setVisibility(View.GONE);
//            btnLaporDesa.setVisibility(View.GONE);
        }else{
            btnCariKKN.setVisibility(View.VISIBLE);
//            btnBantuDesa.setVisibility(View.VISIBLE);
//            btnLaporDesa.setVisibility(View.VISIBLE);
        }
    }
}
