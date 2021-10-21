package com.example.uts_pbp_d_kel7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_pbp_d_kel7.dao.UserDao;
import com.example.uts_pbp_d_kel7.database.DatabaseUser;
import com.example.uts_pbp_d_kel7.model.User;
import com.example.uts_pbp_d_kel7.preferences.UserPreferences;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout etUsername, etPassword;
    private MaterialButton btnLogin, btnRegister;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userPreferences = new UserPreferences(LoginActivity.this);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        checkLogin();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inUsername = etUsername.getEditText().getText().toString();
                String inPassword = etPassword.getEditText().getText().toString();
                if(validateForm(inUsername,inPassword)){
                    DatabaseUser databaseUser = DatabaseUser.getInstance(LoginActivity.this);
                    UserDao userDao = databaseUser.getDatabase().userDao();
                    User user = userDao.login(inUsername,inPassword);
                    if(user == null){
                        Toast.makeText(LoginActivity.this,
                                "Invalid username/password", Toast.LENGTH_SHORT).show();
                    } else {
                        userPreferences.setLogin(etUsername.getEditText().getText().toString().trim(),
                                etPassword.getEditText().getText().toString().trim());
                        checkLogin();
                        String username = user.getUsername();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class)
                                .putExtra("username", username));
                    }
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private boolean validateForm(String username, String password){
        if (username.isEmpty() || password.isEmpty()){
            Toast.makeText(LoginActivity.this, "Username atau Password Kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void checkLogin() {
        if(userPreferences.checkLogin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }
}
