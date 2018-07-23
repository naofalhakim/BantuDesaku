package com.example.user.bangundesaku.menufragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.bangundesaku.R;
import com.example.user.bangundesaku.config.SessionLogin;


public class ProfileFragment extends Fragment {

    private EditText etNama, etKelamin;
    private ImageView imageView;
    private SessionLogin sessionLogin;
    private Button btnSimpan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        sessionLogin = new SessionLogin(getContext());

        etNama = (EditText) v.findViewById(R.id.txt_nama_akun);
        etKelamin= (EditText) v.findViewById(R.id.txt_kelamin);
        imageView= (ImageView) v.findViewById(R.id.img_akun);
        btnSimpan= (Button) v.findViewById(R.id.btn_simpan_akun);

        etNama.setText(sessionLogin.getDataString(SessionLogin.KEY_NAMAUSER));
        etKelamin.setText(sessionLogin.getDataString(SessionLogin.KEY_KELAMINSUSER));

        if(sessionLogin.getDataString(sessionLogin.KEY_KELAMINSUSER).equals("Laki-Laki")){
            imageView.setImageResource(R.drawable.avatar);
        }else {
            imageView.setImageResource(R.drawable.avatarcewek);
        }

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Data Tersimpan",Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
