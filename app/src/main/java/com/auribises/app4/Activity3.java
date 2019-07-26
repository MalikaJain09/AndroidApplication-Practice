package com.auribises.app4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    TableLayout eTxtMulti;
    TextView eTxt;
    void initView(){
        eTxtMulti=findViewById(R.id.table_main);
        eTxt=findViewById(R.id.textView);
        Intent rcv = getIntent();
        String no = rcv.getStringExtra("keyNo");
        int multi = Integer.parseInt(no);
        eTxt.setText("Multiplication Table of "+multi);


        for (int i = 0 ; i<=10;i++){
            TableRow tbrow0 = new TableRow(this);
            TextView tv0 = new TextView(this);
            int ans=multi*i;
            tv0.setText(multi+" * "+i+" = "+ans+"\n");
            tv0.setTextColor(Color.rgb(0,0,0));
            tbrow0.setGravity(Gravity.CENTER);
            tv0.setGravity(Gravity.CENTER);
            tv0.setTextSize(30);
            tbrow0.addView(tv0);
            eTxtMulti.addView(tbrow0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        getSupportActionBar().setTitle("Table");

        initView();
    }
    public void getTxt(){

    }
}
