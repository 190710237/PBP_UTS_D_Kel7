package com.example.uts_pbp_d_kel7;

import static com.android.volley.Request.Method.DELETE;
import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.POST;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
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

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uts_pbp_d_kel7.adapter.CatatanAdapter;
import com.example.uts_pbp_d_kel7.api.CatatanApi;
import com.example.uts_pbp_d_kel7.model.Catatan;
import com.example.uts_pbp_d_kel7.model.CatatanResponse;
import com.example.uts_pbp_d_kel7.model.User;
import com.example.uts_pbp_d_kel7.preferences.UserPreferences;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CatatanActivity extends AppCompatActivity {
public static final int LAUNCH_ADD_ACTIVITY = 123;

private SwipeRefreshLayout srCatatan;
private CatatanAdapter adapter;
private LinearLayout layoutLoading;
private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);

        queue = Volley.newRequestQueue(this);

        layoutLoading = findViewById(R.id.layout_loading);
        srCatatan = findViewById(R.id.sr_catatan);
        srCatatan.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllCatatan();
            }
        });

        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCreateDialog();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LAUNCH_ADD_ACTIVITY && resultCode == Activity.RESULT_OK){
            getAllCatatan();
        }
    }

    private void getAllCatatan(){
        srCatatan.setRefreshing(true);

        StringRequest stringRequest = new StringRequest(GET, CatatanApi.GET_ALL_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                CatatanResponse catatanResponse = gson.fromJson(response, CatatanResponse.class);
                adapter.setCatatanList(catatanResponse.getCatatanList());
                Toast.makeText(CatatanActivity.this, catatanResponse.getMessage(), Toast.LENGTH_SHORT).show();
                srCatatan.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                srCatatan.setRefreshing(false);
                try{
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(CatatanActivity.this,
                            errors.getString("message"), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(CatatanActivity.this, e.getMessage(),
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

    public void deleteCatatan(long id){
        setLoading(true);
        StringRequest stringRequest = new StringRequest(DELETE, CatatanApi.DELETE_URL + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                CatatanResponse catatanResponse = gson.fromJson(response, CatatanResponse.class);
                setLoading(false);
                Toast.makeText(CatatanActivity.this, catatanResponse.getMessage(), Toast.LENGTH_SHORT).show();
                getAllCatatan();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setLoading(false);
                try {
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(CatatanActivity.this,
                            errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(CatatanActivity.this, e.getMessage(),
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
        final Dialog dialog = new Dialog(CatatanActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.create_catatan_dialog);
        final EditText txtJudul = dialog.findViewById(R.id.txtJudul);
        Button btnSubmit = dialog.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener((v) -> {
            String judul = txtJudul.getText().toString();
            addCatatan(judul);
            dialog.dismiss();
        });

        dialog.show();
    }
    private void addCatatan(String judul){
        setLoading(true);
        UserPreferences userPreferences = new UserPreferences(this);
        User user = userPreferences.getUserLogin();
        Catatan catatan = new Catatan(
                judul,
                "",
                (long) user.getId()
        );

        StringRequest stringRequest = new StringRequest(POST, CatatanApi.ADD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        CatatanResponse catatanResponse = gson.fromJson(response, CatatanResponse.class);
                        Toast.makeText(CatatanActivity.this, catatanResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        ;
                        setLoading(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try{
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(CatatanActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(CatatanActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
}