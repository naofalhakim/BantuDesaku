package com.example.user.bangundesaku.intro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bangundesaku.R;
import com.example.user.bangundesaku.StartedActivity;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener{

    public ViewPager slider;
    private Button btnSkip, btnNext;
    private TextView[] tanda;
    private LinearLayout layoutTitik;
    int posisi;
    private RelativeLayout rel;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        slider = (ViewPager) findViewById(R.id.vp_myslider);
        btnNext = (Button) findViewById(R.id.btn_lanjut);
        btnSkip = (Button) findViewById(R.id.btn_lewati);
        layoutTitik = (LinearLayout) findViewById(R.id.layout_titik);
        rel = (RelativeLayout) findViewById(R.id.rel_back_slider);

        btnNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);

        slider.setAdapter(new SliderAdapter(IntroActivity.this));
        rel.setBackgroundColor(getBackColor(posisi));

        tambahIndokator(0);
        slider.addOnPageChangeListener(changeListener);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        if (v == btnNext) {
            if (posisi < 2) {
                slider.setCurrentItem(posisi + 1);
                rel.setBackgroundColor(getBackColor(posisi));
                Log.e("warna",getBackColor(posisi)+"");
            } else{
                startActivity(new Intent(IntroActivity.this, StartedActivity.class));
                finish();
            }
        } else if (v == btnSkip) {
            if (posisi > 0) {
                slider.setCurrentItem(posisi - 1);
                rel.setBackgroundColor(getBackColor(posisi));
                Log.e("warna",getBackColor(posisi)+"");
            } else{
                startActivity(new Intent(IntroActivity.this, StartedActivity.class));
                finish();
            }
        }
    }

    public void tambahIndokator(int position) {
        tanda = new TextView[3];
        layoutTitik.removeAllViews();

        for (int i = 0; i < tanda.length; i++) {
            tanda[i] = new TextView(this);
            tanda[i].setBackgroundResource(R.drawable.bintik_background);
            tanda[i].setWidth(40);
            tanda[i].setHeight(40);

            layoutTitik.addView(tanda[i]);
        }
        if (tanda.length > 0) {
            tanda[position].setBackgroundResource(R.drawable.button_background);
        }
        if (position > 0) {
            btnSkip.setText("BACK");
        }else{
            btnSkip.setText("SKIP");
            btnNext.setText("NEXT");
        }
        if(position == 2){
            btnNext.setText("DONE");
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            tambahIndokator(position);
//            ini caranya ngeget posisi konten yang ditampilkan saat ini, sengaja di isikan ke variable global 'posisi' biar bisa dipakek untuk action button next,back, skip
            posisi = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @RequiresApi(api = Build.VERSION_CODES.M)
    public int getBackColor(int posisi){
        switch (posisi){
            case 0:
                return getColor(R.color.colorBgSlide1);
            case 1:
                return getColor(R.color.colorBgSlide2);
            case 2:
                return getColor(R.color.colorBgSlide3);
        }
        return getColor(R.color.colorBgSlide3);
    }
}
