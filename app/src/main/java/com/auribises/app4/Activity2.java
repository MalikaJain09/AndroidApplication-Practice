package com.auribises.app4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    EditText eTxtName,eTxtPhone,eTxtNo;
    void initView(){
        eTxtName=findViewById(R.id.editTextName);
        eTxtPhone=findViewById(R.id.editTextPhone);
        eTxtNo=findViewById(R.id.editTextNo);
        Intent rcv=getIntent();
//        String name= rcv.getStringExtra("keyName");
//        String phone = rcv.getStringExtra("keyPhone");
//        eTxtName.setText(name);
//        eTxtPhone.setText(phone);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().setTitle("Activity Two");

        initView();
    }
    public void clickHandler(View view){
//        Person person1=new Person();
//        person.name=eTxtName.getText().toString();
//
//        person.phone= eTxtPhone.getText().toString();
//
//
//        Intent data = new Intent();
//        data.putExtra(Util.Ket_Name,person);
//        setResult(201,data);
        String name = eTxtName.getText().toString();
        String phone = eTxtPhone.getText().toString();

        // Put Data in an Empty Intent
        Intent data = new Intent();

        data.putExtra("keyName", name);
        data.putExtra("keyPhone", phone);

        setResult(201, data);
        finish();
    }
}
