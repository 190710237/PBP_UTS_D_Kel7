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
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.uts_pbp_d_kel7.model.User;
import com.example.uts_pbp_d_kel7.preferences.UserPreferences;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class ProfileFragment extends Fragment{
    private MaterialTextView txtFullname, txtEmail;
    private MaterialTextView txtBirthdate, txtSchoolname;
    private MaterialTextView txtAddress;
    private MaterialButton btnEdit;
    private UserPreferences userPreferences;
    private ImageView iv_profilePicture;
    private User user;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        userPreferences = new UserPreferences(getActivity().getApplicationContext());
        user = userPreferences.getUserLogin();
//        String getUser = user.getUsername();
//        User user = userDao.getLogininfo(getUser);

        iv_profilePicture = view.findViewById(R.id.iv_profilePicture);

        if(user.getPhoto()==null){
            Toast.makeText(getActivity().getApplicationContext(), "No image", Toast.LENGTH_SHORT).show();
            Glide.with(getActivity().getApplicationContext())
                    .load(R.drawable.no_image)
                    .into(iv_profilePicture);
        }else{
            Glide.with(getActivity().getApplicationContext())
                    .load(user.getPhoto())
                    .into(iv_profilePicture);
        }


        txtFullname = view.findViewById(R.id.txtFullname);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtBirthdate = view.findViewById(R.id.txtBirthdate);
        txtSchoolname = view.findViewById(R.id.txtSchoolName);
        txtAddress = view.findViewById(R.id.txtAddress);
        btnEdit = view.findViewById(R.id.btnEdit);

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

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editProfileIntent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(editProfileIntent);
            }
        });
        return view;
    }

}