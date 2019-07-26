package com.auribises.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LayoutsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        getSupportActionBar().setTitle("Layout Activity");
    }
}
