package com.example.uts_pbp_d_kel7.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp_d_kel7.CatatanActivity;
import com.example.uts_pbp_d_kel7.R;
import com.example.uts_pbp_d_kel7.ViewCatatanActivity;
import com.example.uts_pbp_d_kel7.model.Catatan;
import com.example.uts_pbp_d_kel7.model.User;
import com.example.uts_pbp_d_kel7.preferences.UserPreferences;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.ViewHolder> {
    private List<Catatan> catatanList;
    private UserPreferences userPreferences;

    public CatatanAdapter(List<Catatan> catatanList, Context context) {
        this.catatanList = catatanList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvJudul;
        TextView tvNumber;
        MaterialCardView materialCardView;
        ImageButton btnDelete;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvJudul= itemView.findViewById(R.id.txtJudul);
            tvNumber= itemView.findViewById(R.id.txtNumber);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            materialCardView = itemView.findViewById(R.id.card);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        userPreferences = new UserPreferences(parent.getContext());
        View view = inflater.inflate(R.layout.rv_item_catatan,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Catatan catatan = catatanList.get(position);
        holder.tvJudul.setText(catatan.getJudul());
        holder.tvNumber.setText(String.valueOf(position+1));
        holder.materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewCatatanActivity.class);
                intent.putExtra("id",catatan.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder =
                        new MaterialAlertDialogBuilder(holder.itemView.getContext());
                materialAlertDialogBuilder.setTitle("Konfirmasi")
                        .setMessage("Apakah anda yakin ingin menghapus data mahasiswaini?")
                        .setNegativeButton("Batal", null)
                        .setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (holder.itemView.getContext() instanceof CatatanActivity)
                                    ((CatatanActivity)holder.itemView.getContext()).deleteCatatan(catatan.getId());
                            }
                        })
                        .show();
            }
        });
    }

    public void setCatatanList(List<Catatan> catatanList) {
        User user = userPreferences.getUserLogin();
        List<Catatan> filter = new ArrayList<>();
        int id = user.getId();
        for(int i = 0; i < catatanList.size(); i++){
            if(catatanList.get(i).getUser_id() == id){
                filter.add(catatanList.get(i));
            }
        }
        this.catatanList = filter;
    }
    @Override
    public int getItemCount() {
        return catatanList.size();
    }
}
