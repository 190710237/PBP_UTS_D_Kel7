package com.example.uts_pbp_d_kel7;

import static com.android.volley.Request.Method.POST;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uts_pbp_d_kel7.api.UserApi;
import com.example.uts_pbp_d_kel7.model.User;
import com.example.uts_pbp_d_kel7.model.UserResponse;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import retrofit2.http.POST;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout etFirstname, etLastname, etEmail;
    private TextInputLayout etUsername, etPassword, etConfirmPassword;
    private MaterialButton btnLogin, btnRegister;
    private LinearLayout layoutLoading;
    static RegisterActivity instance;
    private RequestQueue queue;

    //TODO CONVERT TO VOLLEY

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        queue = Volley.newRequestQueue(this);
        etFirstname = findViewById(R.id.etFirstName);
        etLastname = findViewById(R.id.etLastName);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        layoutLoading = findViewById(R.id.layout_loading);

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
                    //cek field kosong & cek password & confirm password
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
        setLoading(true);
        final String firstname = etFirstname.getEditText().getText().toString();
        final String lastname = etLastname.getEditText().getText().toString();
        final String username = etUsername.getEditText().getText().toString();
        final String email  = etEmail.getEditText().getText().toString();
        final String password = etPassword.getEditText().getText().toString();

        User user = new User(username, password, firstname, lastname, email);

        StringRequest stringRequest = new StringRequest(POST, UserApi.REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();

                        UserResponse userResponse = gson.fromJson(response, UserResponse.class);

                        Toast.makeText(RegisterActivity.this, userResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        Intent returnIntent = new Intent();
                        setResult(Activity.RESULT_OK, returnIntent);
                        finish();

                        setLoading(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setLoading(false);

                try{
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);

                    Toast.makeText(RegisterActivity.this,
                            errors.getString("message"), Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    Toast.makeText(RegisterActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            //Header
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");

                return headers;
            }

            //Body
            @Override
            public byte[] getBody() throws AuthFailureError {
                Gson gson = new Gson();
                /* Serialisasi data dari java object
                menjadi JSON string menggunakan Gson */
                String requestBody = gson.toJson(user);

                return requestBody.getBytes(StandardCharsets.UTF_8);
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };

        //add to queue
        queue.add(stringRequest);
    }

    private void setLoading(boolean isLoading) {
        if (isLoading) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.VISIBLE);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.GONE);
        }
    }
}
