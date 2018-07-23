package com.example.user.bangundesaku.intro;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.bangundesaku.R;


/**
 * Created by user on 03/07/2018.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public String isiTitle[] = {"Bantu Desa","Galang Dana","Minta Bantuan"};
    public String isikonten[] = {"Disini, mahasiswa dan dosen dapat melihat daftar desa yang mambutuhkan bantuan","Para donatur dapat memberikan donasi kepada desa yang membutuhkan via KKN", "Kepala desa dapat memberitahu bahwa desa tersebut membutuhkan bantuan atau tidak"};
    public int isiGambar[] = {R.drawable.slider1,R.drawable.slider2,R.drawable.slider3};

    public SliderAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return isikonten.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v= layoutInflater.from(context).inflate(R.layout.content_slider,container,false);

        TextView txtIsiContent = (TextView) v.findViewById(R.id.txt_isi);
        TextView txtJudulContent = (TextView) v.findViewById(R.id.txt_judul);
        ImageView img = (ImageView) v.findViewById(R.id.img_content);

        txtIsiContent.setText(isikonten[position]);
        txtJudulContent.setText(isiTitle[position]);
        img.setImageResource(isiGambar[position]);


        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }


}
