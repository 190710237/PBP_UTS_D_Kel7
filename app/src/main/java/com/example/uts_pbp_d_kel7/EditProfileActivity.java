package com.example.uts_pbp_d_kel7;

import static com.android.volley.Request.Method.POST;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class EditProfileActivity extends AppCompatActivity {
    private TextInputLayout etFirstname, etLastname;
    private TextInputLayout etBirthdate, etSchoolname, etAddress;
    private MaterialButton btnBack, btnSave;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormat;
    private ImageView ivProfilePicture;
    private Bitmap bitmap = null;
    private LinearLayout layoutLoading;

    private UserPreferences userPreferences;
    private User user;
    private RequestQueue queue;

    private static final int PERMISSION_REQUEST_CAMERA = 100;
    private static final int CAMERA_REQUEST = 0;
    private static final int GALLERY_PICTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        bitmap = null;
        userPreferences = new UserPreferences(EditProfileActivity.this);
        user = userPreferences.getUserLogin();
        queue = Volley.newRequestQueue(this);
        ivProfilePicture = findViewById(R.id.iv_profilePicture);
        etFirstname = findViewById(R.id.etFirstName);
        etLastname = findViewById(R.id.etLastName);
        etBirthdate = findViewById(R.id.etBirthDate);
        etSchoolname = findViewById(R.id.etSchoolName);
        etAddress = findViewById(R.id.etAddress);
        btnBack = findViewById(R.id.btnBack);
        btnSave = findViewById(R.id.btnSave);
        layoutLoading = findViewById(R.id.layout_loading);

        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        ivProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = LayoutInflater.from(EditProfileActivity.this);
                View selectMediaView = layoutInflater
                        .inflate(R.layout.layout_select_media, null);

                final AlertDialog alertDialog = new AlertDialog
                        .Builder(selectMediaView.getContext()).create();

                Button btnKamera = selectMediaView.findViewById(R.id.btn_kamera);
                Button btnGaleri = selectMediaView.findViewById(R.id.btn_galeri);

                btnKamera.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (checkSelfPermission(Manifest.permission.CAMERA) ==
                                PackageManager.PERMISSION_DENIED) {
                            String[] permission = {Manifest.permission.CAMERA};
                            requestPermissions(permission, PERMISSION_REQUEST_CAMERA);
                        } else {
                            // Membuka kamera
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, CAMERA_REQUEST);
                        }

                        alertDialog.dismiss();
                    }
                });

                btnGaleri.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Membuka galeri
                        Intent intent = new Intent(Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, GALLERY_PICTURE);

                        alertDialog.dismiss();
                    }
                });

                alertDialog.setView(selectMediaView);
                alertDialog.show();
            }
        });

        etFirstname.getEditText().setText(user.getFirstname());
        etLastname.getEditText().setText(user.getLastname());
        if(user.getBirthdate()!=null){
            etBirthdate.getEditText().setText(user.getBirthdate());
        }
        if(user.getSchoolname()!=null){
            etSchoolname.getEditText().setText(user.getSchoolname());
        }
        if(user.getAddress()!=null){
            etAddress.getEditText().setText(user.getAddress());
        }

        etBirthdate.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalendar = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(EditProfileActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);

                        user.setBirthdate(dateFormat.format(newDate.getTime()));
                        etBirthdate.getEditText().setText(dateFormat.format(newDate.getTime()));
                    }
                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH),
                        newCalendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateForm()==1){
                    updateUser();
//                    String username = user.getUsername();
//                    startActivity(new Intent(EditProfileActivity.this, MainActivity.class)
//                            .putExtra("username",username));
                }
            }
        });
    }

    private int validateForm(){
        String firstname =  etFirstname.getEditText().getText().toString();
        String lastname = etLastname.getEditText().getText().toString();
        String birthdate = etBirthdate.getEditText().getText().toString();
        String schoolname = etSchoolname.getEditText().getText().toString();
        String address = etAddress.getEditText().getText().toString();
        if (firstname.isEmpty() || lastname.isEmpty() || birthdate.isEmpty() ||
                schoolname.isEmpty() || address.isEmpty()){
            Toast.makeText(EditProfileActivity.this, "Ada field yang Kosong!", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return 1;
    }
    private void updateUser(){
        setLoading(true);

        BitmapDrawable drawable = (BitmapDrawable) ivProfilePicture.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        final int id = user.getId();
        final String username = user.getUsername();
        final String password = user.getPassword();
        final String email = user.getEmail();
        final String firstname = etFirstname.getEditText().getText().toString();
        final String lastname = etLastname.getEditText().getText().toString();
        final String birthdate = etBirthdate.getEditText().getText().toString();
        final String schoolname  = etSchoolname.getEditText().getText().toString();
        final String address = etAddress.getEditText().getText().toString();
        final String photo = bitmapToBase64(bitmap);
        final int token = user.getToken();
        final Boolean verified = user.getVerified();

        User user = new User(id, username, password, firstname, lastname, email, birthdate,
                schoolname, address, photo, token, verified);

        StringRequest stringRequest = new StringRequest(POST, UserApi.UPDATE_USER + String.valueOf(id),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();

                        UserResponse userResponse = gson.fromJson(response, UserResponse.class);

                        Toast.makeText(EditProfileActivity.this, userResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        User userEdit = userResponse.getUserList().get(0);
                        userPreferences.setLogin(userEdit.getId(), userEdit.getUsername(), userEdit.getPassword(),
                                userEdit.getFirstname(), userEdit.getLastname(), userEdit.getEmail(), userEdit.getBirthdate(),
                                userEdit.getSchoolname(),userEdit.getAddress(),userEdit.getPhoto(),userEdit.getToken(),
                                userEdit.getVerified());

                        startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
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

                    Toast.makeText(EditProfileActivity.this,
                            errors.getString("message"), Toast.LENGTH_SHORT).show();

                } catch (Exception e){
                    Toast.makeText(EditProfileActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            //Meanmbahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");

                return headers;
            }

            //Menambahkan request body berupa object User
            @Override
            public byte[] getBody() throws AuthFailureError {
                Gson gson = new Gson();
                /* Serialisasi data dari java object ProdukResponse
                menjadi JSON string menggunakan Gson */
                String requestBody = gson.toJson(user);

                return requestBody.getBytes(StandardCharsets.UTF_8);
            }

            // Mendeklarasikan content type dari request body yang ditambahkan
            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };

        queue.add(stringRequest);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Membuka kamera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST);
            } else {
                Toast.makeText(EditProfileActivity.this, "Permission denied.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null)
            return;

        if (resultCode == RESULT_OK && requestCode == GALLERY_PICTURE) {
            Uri selectedImage = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(selectedImage);
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                Toast.makeText(EditProfileActivity.this, e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        } else if (resultCode == RESULT_OK && requestCode == CAMERA_REQUEST) {
            bitmap = (Bitmap) data.getExtras().get("data");
        }

        bitmap = getResizedBitmap(bitmap, 256);
        ivProfilePicture.setImageBitmap(bitmap);
    }

    private Bitmap getResizedBitmap(Bitmap bitmap, int maxSize) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        float bitmapRatio = (float) width / (float) height;

        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }

        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    private String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, outputStream);

        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
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