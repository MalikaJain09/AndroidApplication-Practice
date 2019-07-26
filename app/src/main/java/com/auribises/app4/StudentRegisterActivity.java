package com.auribises.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class StudentRegisterActivity extends AppCompatActivity implements AdapterView.OnClickListener {
    EditText eTxtName, eTxtPhone, eTxtEmail, eTxtMother, eTxtFather, eTxtBranch, eTxtRollNo, eTxtAddress;
    RadioButton rMale, rFemale;
    Spinner spinnerCity;
    ArrayAdapter<String> adapter;
    Button btnSubmit;
    RatingBar ratingBar;
    Student sRef;

    void initviews() {
        eTxtName = findViewById(R.id.editTextName);
        eTxtPhone = findViewById(R.id.editTextPhone);
        eTxtEmail = findViewById(R.id.editTextEmail);
        eTxtMother = findViewById(R.id.editTextMothersName);
        eTxtFather = findViewById(R.id.editTextFathersName);
        eTxtBranch = findViewById(R.id.editTextBranch);
        eTxtRollNo = findViewById(R.id.editTextRollNo);
        eTxtAddress = findViewById(R.id.editTextAddress);
        rMale = findViewById(R.id.radioMale);
        rFemale = findViewById(R.id.radioFemale);
        spinnerCity = findViewById(R.id.spinnerCity);
        btnSubmit = findViewById(R.id.buttonSubmit);
        ratingBar = findViewById(R.id.ratingBar);
        sRef = new Student();

        btnSubmit.setOnClickListener(this);
        rMale.setOnClickListener(this);
        rFemale.setOnClickListener(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Select City");
        adapter.add("Ludhiana");
        adapter.add("Delhi");
        adapter.add("Banglore");
        adapter.add("Hyderabad");
        adapter.add("Mumbai");

        spinnerCity.setAdapter(adapter);
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                sRef.city = adapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                sRef.rating=v;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        initviews();

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.buttonSubmit) {

            sRef.name = eTxtName.getText().toString();
            sRef.phone = eTxtPhone.getText().toString();
            sRef.email = eTxtEmail.getText().toString();
            sRef.mothersName = eTxtMother.getText().toString();
            sRef.fathersName=eTxtFather.getText().toString();
            sRef.branch = eTxtBranch.getText().toString();
            sRef.permanetAddress = eTxtAddress.getText().toString();
            sRef.rollNo = eTxtRollNo.getText().toString();


            Toast.makeText(this, sRef.toString(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(StudentRegisterActivity.this, ConfirmStudentDetailsActivity.class);
            intent.putExtra("keyStudent", sRef);
            startActivity(intent);

        } else if (id == R.id.radioMale) {

            sRef.gender = "Male";

        } else if (id == R.id.radioFemale) {
            sRef.gender = "Female";

        }
    }
}
