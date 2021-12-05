package com.example.uts_pbp_d_kel7;

import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.POST;
import static com.android.volley.Request.Method.PUT;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.uts_pbp_d_kel7.preferences.UserPreferences;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout etUsername, etPassword;
    private MaterialButton btnLogin, btnRegister;
    private UserPreferences userPreferences;
    private LinearLayout layoutLoading;
    private RequestQueue queue;

    //TODO CONVERT TO VOLLEY

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        queue = Volley.newRequestQueue(this);
        userPreferences = new UserPreferences(LoginActivity.this);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        layoutLoading = findViewById(R.id.layout_loading);

        checkLogin();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inUsername = etUsername.getEditText().getText().toString();
                String inPassword = etPassword.getEditText().getText().toString();

                //cek database user
                if(validateForm(inUsername,inPassword)){
                    loginUser();
                    if(userPreferences.getUserLogin().getVerified()==true){
                        checkLogin();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        if(userPreferences.getUserLogin().getUsername()!=null)
                        {showCreateDialog();}
                    }
//                    DatabaseUser databaseUser = DatabaseUser.getInstance(LoginActivity.this);
//                    UserDao userDao = databaseUser.getDatabase().userDao();
//                    User user = userDao.login(inUsername,inPassword);
//                    if(user == null){
//                        Toast.makeText(LoginActivity.this,
//                                "Invalid username/password", Toast.LENGTH_SHORT).show();
//                    } else {
//                        userPreferences.setLogin(etUsername.getEditText().getText().toString(),
//                                etPassword.getEditText().getText().toString());
//                        checkLogin();
//                        String username = user.getUsername();
//                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    }
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

    private void loginUser(){
//        setLoading(true);
        final String username = etUsername.getEditText().getText().toString();
        final String password = etPassword.getEditText().getText().toString();

        User user = new User(username, password);

        StringRequest stringRequest = new StringRequest(POST, UserApi.LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();

                        UserResponse userResponse = gson.fromJson(response, UserResponse.class);
                        User userLogin = userResponse.getUserList().get(0);

                        Toast.makeText(LoginActivity.this, userResponse.getMessage(), Toast.LENGTH_SHORT).show();

//                        setLoading(false);

                        userPreferences.setLogin(userLogin.getId(), userLogin.getUsername(), userLogin.getPassword(),
                                userLogin.getFirstname(), userLogin.getLastname(), userLogin.getEmail(), userLogin.getBirthdate(),
                                userLogin.getSchoolname(),userLogin.getAddress(),userLogin.getPhoto(),userLogin.getToken(),
                                userLogin.getVerified());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                setLoading(false);

                try{
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);

                    Toast.makeText(LoginActivity.this,
                            errors.getString("message"), Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    Toast.makeText(LoginActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        }){
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

        queue.add(stringRequest);
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

    private void showCreateDialog(){
        final Dialog dialog = new Dialog(LoginActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.verify_dialog);
        final EditText etToken = dialog.findViewById(R.id.etToken);

        Button btnSubmit = dialog.findViewById(R.id.btnSubmitToken);

        btnSubmit.setOnClickListener((v) -> {
            int token = Integer.parseInt(etToken.getText().toString());
            if(token==userPreferences.getUserLogin().getToken()){
                verify(token);
            }else{
                userPreferences.logout();
            }
            dialog.dismiss();
        });

        dialog.show();
    }

    private void verify(int token){
//        setLoading(true);

        StringRequest stringRequest = new StringRequest(GET, UserApi.VERIFY+String.valueOf(userPreferences.getUserLogin().getId()),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();

                        UserResponse userResponse = gson.fromJson(response, UserResponse.class);
                        User userLogin = userResponse.getUserList().get(0);

                        Toast.makeText(LoginActivity.this, userResponse.getMessage(), Toast.LENGTH_SHORT).show();

//                        setLoading(false);

                        userPreferences.setLogin(userLogin.getId(), userLogin.getUsername(), userLogin.getPassword(),
                                userLogin.getFirstname(), userLogin.getLastname(), userLogin.getEmail(), userLogin.getBirthdate(),
                                userLogin.getSchoolname(),userLogin.getAddress(),userLogin.getPhoto(),userLogin.getToken(),
                                userLogin.getVerified());

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                setLoading(false);

                try{
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);

                    Toast.makeText(LoginActivity.this,
                            errors.getString("message"), Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    Toast.makeText(LoginActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        }){
            //Header
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");

                return headers;
            }
        };

        queue.add(stringRequest);;
    }
}
