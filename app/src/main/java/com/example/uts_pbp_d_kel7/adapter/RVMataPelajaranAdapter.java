package com.example.uts_pbp_d_kel7.adapter;

import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp_d_kel7.IsiSubBabActivity;
import com.example.uts_pbp_d_kel7.R;
import com.example.uts_pbp_d_kel7.model.DaftarMataPelajaran;
import com.example.uts_pbp_d_kel7.model.MataPelajaran;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class RVMataPelajaranAdapter extends RecyclerView.Adapter<RVMataPelajaranAdapter.viewHolder> {
    private ArrayList<MataPelajaran> mataPelajaran = new DaftarMataPelajaran().MataPelajaran;

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView txtMataPelajaran;
        Chip txtAuthor;
        Chip txtTingkatan;
        LinearLayout layoutMataPelajaran;
        TextView txtCourseNumber;
        public viewHolder(@NonNull View itemView){
            super(itemView);
            txtMataPelajaran = itemView.findViewById(R.id.txtMataPelajaran);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtTingkatan = itemView.findViewById(R.id.txtTingkatan);
            txtCourseNumber = itemView.findViewById(R.id.txtCourseNumber);
            layoutMataPelajaran = itemView.findViewById(R.id.layout_mata_pelajaran);
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_mata_pelajaran,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.txtMataPelajaran.setText(mataPelajaran.get(position).getMataPelajaran());
        holder.txtAuthor.setText(mataPelajaran.get(position).getAuthor());
        holder.txtTingkatan.setText(mataPelajaran.get(position).getTingkatan());
        holder.txtCourseNumber.setText(String.valueOf(position + 1));
        String deskripsi = mataPelajaran.get(position).getDeskripsi();
        holder.layoutMataPelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(holder.itemView.getContext(), IsiSubBabActivity.class);
                intent.putExtra("mataPelajaran",holder.txtMataPelajaran.getText().toString());
                intent.putExtra("deskripsi",deskripsi);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mataPelajaran.size();
    }
}
