package com.auribises.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmStudentDetailsActivity extends AppCompatActivity {
    TextView TxtName, TxtPhone, TxtEmail, TxtMother, TxtFather, TxtBranch, TxtRollNo, TxtAddress,TxtGender,TxtCity,TxtRating;
//    Student sRef;

    void initviews() {
        TxtName = findViewById(R.id.textViewName);
        TxtPhone = findViewById(R.id.textViewPhone);
        TxtEmail = findViewById(R.id.textViewEmail);
        TxtMother = findViewById(R.id.textViewMothersName);
        TxtFather = findViewById(R.id.textViewFathersName);
        TxtBranch = findViewById(R.id.textViewBranch);
        TxtRollNo = findViewById(R.id.textViewRollNo);
        TxtAddress = findViewById(R.id.textViewAddress);
        TxtGender = findViewById(R.id.textViewGender);
        TxtCity = findViewById(R.id.textViewCity);
        TxtRating = findViewById(R.id.textViewRating);

        Intent rcv=getIntent();
        Student sRef =(Student)rcv.getSerializableExtra("keyStudent");
        TxtName.setText("Name      : "+ sRef.name);
        TxtPhone.setText("Phone      : "+ sRef.phone);
        TxtFather.setText("Father's Name   : "+ sRef.fathersName);
        TxtMother.setText("Mother's Name   : "+ sRef.mothersName);
        TxtEmail.setText("Email  : "+ sRef.email);
        TxtAddress.setText("Address   : "+ sRef.permanetAddress);
        TxtCity.setText("City    : "+ sRef.city);
        TxtGender.setText("Gender    : "+ sRef.gender);
        TxtBranch.setText("Branch       : "+ sRef.branch);
        TxtRollNo.setText("Univ Roll No  : "+ sRef.rollNo);
        TxtRating.setText("Rating        : "+ sRef.rating);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_student_details);
        initviews();
    }
}
