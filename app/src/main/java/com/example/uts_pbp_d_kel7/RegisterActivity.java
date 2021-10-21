package com.example.uts_pbp_d_kel7;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_pbp_d_kel7.database.DatabaseUser;
import com.example.uts_pbp_d_kel7.model.User;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout etFirstname, etLastname, etEmail;
    private TextInputLayout etUsername, etPassword, etConfirmPassword;
    private MaterialButton btnLogin, btnRegister;
    static RegisterActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstname = findViewById(R.id.etFirstName);
        etLastname = findViewById(R.id.etLastName);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(validateForm()==1){
                        addUser();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    }
                }
        });
    }

    private int validateForm(){
        String firstname =  etFirstname.getEditText().getText().toString();
        String lastname = etLastname.getEditText().getText().toString();
        String email = etEmail.getEditText().getText().toString();
        String username = etUsername.getEditText().getText().toString();
        String password = etPassword.getEditText().getText().toString();
        String confirmpass = etConfirmPassword.getEditText().getText().toString();
        if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() ||
            username.isEmpty() || password.isEmpty() || confirmpass.isEmpty()){
            Toast.makeText(RegisterActivity.this, "Ada field yang Kosong!", Toast.LENGTH_SHORT).show();
            return 0;
        }
        else if (!password.equals(confirmpass)){
            Toast.makeText(RegisterActivity.this, "Password tidak sesuai!", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return 1;
    }

    private void addUser(){
        final String firstname = etFirstname.getEditText().getText().toString();
        final String lastname = etLastname.getEditText().getText().toString();
        final String username = etUsername.getEditText().getText().toString();
        final String email  = etEmail.getEditText().getText().toString();
        final String password = etPassword.getEditText().getText().toString();

        class AddUser extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User();
                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);

                DatabaseUser.getInstance(getApplicationContext())
                        .getDatabase()
                        .userDao()
                        .registerUser(user);

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Toast.makeText(RegisterActivity.this, "Berhasil Register",Toast.LENGTH_SHORT).show();
            }

        }
        AddUser addTodo = new AddUser();
        addTodo.execute();
    }
}
