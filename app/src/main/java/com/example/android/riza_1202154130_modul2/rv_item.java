package com.example.android.riza_1202154130_modul2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class rv_item extends RecyclerView.Adapter<rv_item.ViewHolder> {
    private ArrayList<String> rvData;
    private ArrayList<String> rvHarga;
    private ArrayList<Integer> rvGambar;
    private RelativeLayout ItemList;
    private Context context;

    public rv_item(ArrayList<String> inputData, ArrayList<String> dataHarga, ArrayList<Integer> gambar) {
        rvData = inputData;
        rvHarga = dataHarga;
        rvGambar = gambar;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        //hanya menggunakan data String untuk tiap item
        public TextView tvTitle;
        public TextView tvSubtitle;
        public ImageView iv_menu;

        public ViewHolder(View v) {
            super(v);
            context = itemView.getContext();
            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvSubtitle = (TextView) v.findViewById(R.id.tv_subtitle);
            iv_menu = (ImageView) v.findViewById(R.id.icon);
            ItemList = v.findViewById(R.id.list);

            ItemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0 :
                            intent = new Intent(context, breakfast.class);
                            break;
                        case 1 :
                            intent = new Intent(context,lunch.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rv_item, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
        final String name = rvData.get(position);
        final String harga = rvHarga.get(position);
        final Integer gambar = rvGambar.get(position);
        holder.tvTitle.setText(name);
        holder.tvSubtitle.setText(harga);
        holder.iv_menu.setImageResource(gambar);
    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }
}