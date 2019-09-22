package com.example.aplikasisupi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.aplikasisupi.R;
import com.example.aplikasisupi.model.ReadSensorItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//1
public class AdapterGetData extends RecyclerView.Adapter<AdapterGetData.ViewHolder> {

    Context context;
    List<ReadSensorItem> dataItem;

    //2
    public AdapterGetData(Context context, List<ReadSensorItem> dataItem) {
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //3
        View view = LayoutInflater.from(context).inflate(R.layout.item_monitoring_suhu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtDate.setText("Tanggal :" +dataItem.get(position).getTanggal());
        holder.txtTime.setText("Waktu :" +dataItem.get(position).getWaktu());
        holder.txtSuhu.setText("Kondisi Suhu :" +dataItem.get(position).getSuhu());
        holder.txtKondisi.setText("Keterangan Kondisi :" +dataItem.get(position).getKondisi());
    }

    @Override
    public int getItemCount() {
        //4
        return dataItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_date)
        TextView txtDate;
        @BindView(R.id.txt_time)
        TextView txtTime;
        @BindView(R.id.txt_suhu)
        TextView txtSuhu;
        @BindView(R.id.txt_kondisi)
        TextView txtKondisi;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
