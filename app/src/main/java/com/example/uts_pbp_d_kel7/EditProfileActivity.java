package com.example.uts_pbp_d_kel7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.uts_pbp_d_kel7.dao.UserDao;
import com.example.uts_pbp_d_kel7.database.DatabaseUser;
import com.example.uts_pbp_d_kel7.model.User;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EditProfileActivity extends AppCompatActivity {
    private TextInputLayout etFirstname, etLastname;
    private TextInputLayout etBirthdate, etSchoolname, etAddress;
    private MaterialButton btnBack, btnSave;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        etFirstname = findViewById(R.id.etFirstName);
        etLastname = findViewById(R.id.etLastName);
        etBirthdate = findViewById(R.id.etBirthDate);
        etSchoolname = findViewById(R.id.etSchoolName);
        etAddress = findViewById(R.id.etAddress);
        btnBack = findViewById(R.id.btnBack);
        btnSave = findViewById(R.id.btnSave);

        DatabaseUser databaseUser = DatabaseUser.getInstance(EditProfileActivity.this);
        UserDao userDao = databaseUser.getDatabase().userDao();
        String getUser = getIntent().getStringExtra("username");
        User user = userDao.getLogininfo(getUser);

        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

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
                    updateUser(user);
                    String username = user.getUsername();
                    startActivity(new Intent(EditProfileActivity.this, MainActivity.class)
                            .putExtra("username",username));
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
    private void updateUser(User user){
        final String firstname = etFirstname.getEditText().getText().toString();
        final String lastname = etLastname.getEditText().getText().toString();
        final String birthdate = etBirthdate.getEditText().getText().toString();
        final String schoolname  = etSchoolname.getEditText().getText().toString();
        final String address = etAddress.getEditText().getText().toString();

        class UpdateUser extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {

                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setBirthdate(birthdate);
                user.setSchoolname(schoolname);
                user.setAddress(address);

                DatabaseUser.getInstance(getApplicationContext())
                        .getDatabase()
                        .userDao()
                        .updateUser(user);

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Toast.makeText(EditProfileActivity.this, "Berhasil mengedit data",Toast.LENGTH_SHORT).show();
            }

        }
        UpdateUser updateUser = new UpdateUser();
        updateUser.execute();
    }
}