package com.example.uts_pbp_d_kel7;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uts_pbp_d_kel7.dao.UserDao;
import com.example.uts_pbp_d_kel7.database.DatabaseUser;
import com.example.uts_pbp_d_kel7.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class ProfileFragment extends Fragment{
    private MaterialTextView txtFullname, txtEmail;
    private MaterialTextView txtBirthdate, txtSchoolname;
    private MaterialTextView txtAddress;
    private MaterialButton btnEdit, btnBack;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        DatabaseUser databaseUser = DatabaseUser.getInstance(getContext());
        UserDao userDao = databaseUser.getDatabase().userDao();
        String getUser = getActivity().getIntent().getStringExtra("username");
        User user = userDao.getLogininfo(getUser);

        txtFullname = view.findViewById(R.id.txtFullname);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtBirthdate = view.findViewById(R.id.txtBirthdate);
        txtSchoolname = view.findViewById(R.id.txtSchoolName);
        txtAddress = view.findViewById(R.id.txtAddress);
        btnEdit = view.findViewById(R.id.btnEdit);
        btnBack = view.findViewById(R.id.btnBack);

        txtFullname.setText(user.getFirstname()+" "+user.getLastname());
        txtEmail.setText(user.getEmail());
        if(user.getBirthdate()==null){
            txtBirthdate.setText("N/A");
        }else{
            txtBirthdate.setText(user.getBirthdate());
        }
        if(user.getSchoolname()==null){
            txtSchoolname.setText("N/A");
        }else{
            txtSchoolname.setText(user.getSchoolname());
        }
        if(user.getAddress()==null){
            txtAddress.setText("N/A");
        }else{
            txtAddress.setText(user.getAddress());
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editProfileIntent = new Intent(getActivity(), EditProfileActivity.class);
                editProfileIntent.putExtra("username", user.getUsername());
                startActivity(editProfileIntent);
            }
        });
        return view;
    }

}