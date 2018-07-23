package com.example.user.bangundesaku.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.bangundesaku.DetailKKNActivity;
import com.example.user.bangundesaku.R;
import com.example.user.bangundesaku.menuuser.CariKKNActivity;
import com.example.user.bangundesaku.model.RequestKKN;

import java.util.ArrayList;

/**
 * Created by user on 22/07/2018.
 */

public class DataKKNAdapter extends RecyclerView.Adapter<DataKKNAdapter.ViewHolder> {
    private Context context;
    private ArrayList<RequestKKN> requestKKNS;
    private int posisi;

    public DataKKNAdapter(Context context, ArrayList<RequestKKN> kkns) {
        this.context = context;
        this.requestKKNS = kkns;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_kkn,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RequestKKN requestKKN = requestKKNS.get(position);
        holder.txtJudul.setText(requestKKN.getJudul());
        holder.txtKonten.setText(requestKKN.getDeskripsi());
        holder.txtDaerah.setText(requestKKN.getAlamat());
        holder.txtKategori.setText(requestKKN.getKategori());
        holder.imageView.setImageResource(requestKKN.getImage());
        holder.imageView.setTag(requestKKN.getImage());
        posisi = position;
    }

    @Override
    public int getItemCount() {
        return requestKKNS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView;
        private TextView txtJudul, txtKonten, txtKategori, txtDaerah;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_kkn);
            txtJudul = (TextView) itemView.findViewById(R.id.txtx_title_kkn);
            txtKonten = (TextView) itemView.findViewById(R.id.txtx_content_kkn);
            txtKategori = (TextView) itemView.findViewById(R.id.txt_kategori);
            txtDaerah = (TextView) itemView.findViewById(R.id.txt_daerah);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, DetailKKNActivity.class);
            i.putExtra("judul",txtJudul.getText().toString());
            i.putExtra("daerah",txtDaerah.getText().toString());
            i.putExtra("kategori",txtKategori.getText().toString());
            i.putExtra("konten",txtKonten.getText().toString());
            i.putExtra("img",(Integer) imageView.getTag());
            context.startActivity(i);
        }
    }
}
