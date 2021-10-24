package com.example.uts_pbp_d_kel7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uts_pbp_d_kel7.adapter.RVMataPelajaranAdapter;


public class HomeFragment extends Fragment {
    private TextView txtUsername;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        txtUsername = view.findViewById(R.id.txtUserName);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String getUser = getActivity().getIntent().getStringExtra("username");
        txtUsername.setText(getUser);
        RecyclerView rvMataPelajaran= view.findViewById(R.id.rv_matapelajaran);
        rvMataPelajaran.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        rvMataPelajaran.setAdapter(new RVMataPelajaranAdapter());
    }
}