package com.example.uts_pbp_d_kel7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.uts_pbp_d_kel7.adapter.RVSubBabAdapter;

public class IsiSubBabActivity extends AppCompatActivity {
    private TextView txtCourseName;
    private TextView txtCourseDescription;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_sub_bab);

        String mataPelajaran = getIntent().getStringExtra("mataPelajaran");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        txtCourseName = findViewById(R.id.txtCourseName);
        txtCourseName.setText(mataPelajaran);
        txtCourseDescription = findViewById(R.id.txtCourseDescription);
        txtCourseDescription.setText(deskripsi);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        RecyclerView rvSubBab = findViewById(R.id.rv_sub_bab);
        rvSubBab.setLayoutManager(new LinearLayoutManager(this));
        rvSubBab.setAdapter(new RVSubBabAdapter(mataPelajaran));
    }
}