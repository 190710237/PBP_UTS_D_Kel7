package com.example.uts_pbp_d_kel7.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp_d_kel7.IsiMateriActivity;
import com.example.uts_pbp_d_kel7.IsiSubBabActivity;
import com.example.uts_pbp_d_kel7.R;
import com.example.uts_pbp_d_kel7.model.DaftarSubBab;
import com.example.uts_pbp_d_kel7.model.SubBab;

import java.util.ArrayList;

public class RVSubBabAdapter extends RecyclerView.Adapter<RVSubBabAdapter.viewHolders> {
    private ArrayList<SubBab> subBab;

    public class viewHolders extends RecyclerView.ViewHolder{
        TextView txtSubBab;
        TextView txtDeskripsi;
        LinearLayout layoutSubBab;
        public viewHolders(@NonNull View itemView){
            super(itemView);
            txtSubBab = itemView.findViewById(R.id.txtSubBab);
            txtDeskripsi = itemView.findViewById(R.id.txtDeskripsi);
            layoutSubBab = itemView.findViewById(R.id.layout_sub_bab);
        }
    }

    public RVSubBabAdapter(String mataPelajaran) {
        this.subBab = new DaftarSubBab(mataPelajaran).SubBab;
    }

    @NonNull
    @Override
    public viewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolders(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_sub_bab,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolders holder, int position) {
        holder.txtSubBab.setText(subBab.get(position).getNamaBab());
        holder.txtDeskripsi.setText(subBab.get(position).getDeskripsi());
        holder.layoutSubBab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), IsiMateriActivity.class);
                intent.putExtra("subBab",holder.txtSubBab.getText().toString());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subBab.size();
    }
}
