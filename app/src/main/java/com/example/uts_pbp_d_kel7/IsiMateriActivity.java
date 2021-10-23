package com.example.uts_pbp_d_kel7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.uts_pbp_d_kel7.model.Materi;

public class IsiMateriActivity extends AppCompatActivity {
    private TextView tvNamaBab;
    private TextView tvIsiMateri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_materi);
        String konten = getIntent().getStringExtra("subBab");
        tvNamaBab = findViewById(R.id.tv_nama_bab);
        tvIsiMateri = findViewById(R.id.tv_isi_materi);
        tvNamaBab.setText(konten);
        Materi o = new Materi(konten);
        tvIsiMateri.setText(o.getKonten());
    }
}