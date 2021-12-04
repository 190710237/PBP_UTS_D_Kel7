package com.example.uts_pbp_d_kel7;

import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.PUT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uts_pbp_d_kel7.api.CatatanApi;
import com.example.uts_pbp_d_kel7.model.Catatan;
import com.example.uts_pbp_d_kel7.model.CatatanResponse;
import com.example.uts_pbp_d_kel7.model.User;
import com.example.uts_pbp_d_kel7.preferences.UserPreferences;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class ViewCatatanActivity extends AppCompatActivity {
    private Button btnSave;
    private Button btnBack;
    private TextView tvJudul;
    private EditText etIsi;
    private LinearLayout layoutLoading;
    private long id;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_catatan);

        queue = Volley.newRequestQueue(this);

        btnBack = findViewById(R.id.btnBack);
        btnSave = findViewById(R.id.btnSave);
        tvJudul = findViewById(R.id.txtJudul);
        etIsi = findViewById(R.id.etIsi);

        layoutLoading = findViewById(R.id.layout_loading);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        id = getIntent().getLongExtra("id",-1);
        if(id != -1){
            getCatatanById(id);
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateMahasiswa(id);
                }
            });
        }
    }
    private void getCatatanById(long id){
        setLoading(true);
        StringRequest stringRequest = new StringRequest(GET, CatatanApi.GET_BY_ID_URL + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                CatatanResponse catatanResponse = gson.fromJson(response, CatatanResponse.class);
                Catatan catatan = catatanResponse.getCatatanList().get(0);
                tvJudul.setText(catatan.getJudul());
                etIsi.setText(catatan.getIsi());
                Toast.makeText(ViewCatatanActivity.this, catatanResponse.getMessage(), Toast.LENGTH_SHORT).show();
                setLoading(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setLoading(false);
                try{
                    String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(ViewCatatanActivity.this, errors.getString("message"),
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(ViewCatatanActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };
        queue.add(stringRequest);
    }

    private void updateMahasiswa(long id){
        setLoading(true);
        UserPreferences userPreferences = new UserPreferences(this);
        User user = userPreferences.getUserLogin();
        Catatan catatan = new Catatan(
                tvJudul.getText().toString(),
                etIsi.getText().toString(),
                (long) user.getId());

        StringRequest stringRequest = new StringRequest(PUT, CatatanApi.UPDATE_URL + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                CatatanResponse catatanResponse = gson.fromJson(response, CatatanResponse.class);
                Toast.makeText(ViewCatatanActivity.this,
                        catatanResponse.getMessage(), Toast.LENGTH_SHORT).show();
                setLoading(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setLoading(false);
                try {
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(ViewCatatanActivity.this,
                            errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(ViewCatatanActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }

            }
        }){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
            @Override
            public byte[] getBody() throws AuthFailureError {
                Gson gson = new Gson();

                String requestBody = gson.toJson(catatan);
                return requestBody.getBytes(StandardCharsets.UTF_8);
            }
            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        queue.add(stringRequest);
    }

    private void setLoading(boolean isLoading) {
        if (isLoading) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.VISIBLE);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.INVISIBLE);
        }
    }

}