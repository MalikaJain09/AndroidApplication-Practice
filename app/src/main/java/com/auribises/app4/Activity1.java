package com.auribises.app4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    EditText eTxtName ,eTxtPhone;
    void initViews(){
        eTxtName=findViewById(R.id.editTextName);
        eTxtPhone=findViewById(R.id.editTextPhone);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        getSupportActionBar().setTitle("Activity One");
        initViews();
    }
    public void clickHandle(View view){
        String name= eTxtName.getText().toString();
        String phone = eTxtPhone.getText().toString();
        Intent intent = new Intent(Activity1.this,Activity2.class);
//        intent.putExtra("keyName",name);
//        intent.putExtra("keyPhone",phone);
//        Bundle bundle=new Bundle();
//        bundle.putString("keyNmae",name);
//        bundle.getString("keyPhone",phone);
//        bundle.getInt("keyAge",30);
        startActivityForResult(intent,101);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 101 && resultCode == 201){
            String name=data.getStringExtra(Util.Ket_Name);
            String phone = data.getStringExtra(Util.Ket_Phone);

            eTxtName.setText(name);
            eTxtPhone.setText(phone );
        }
    }
}
