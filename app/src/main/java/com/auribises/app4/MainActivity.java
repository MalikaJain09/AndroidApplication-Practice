package com.auribises.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart");
    }

    // When object of activity is visible as a rectangular screen
    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume");
    }

    // When your Activity is partially covered by some other UI Element or Activity
    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause");
    }

    // When user will press back button or programmer executes finish() function
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy");
    }


    // When Your Activity is full covered by some other UI Element ot Activity
    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop");
    }


    public void clickHandler(View view){
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();

        // To navigate from 1 activity to other activity

        // Explicit Way
        // source to destination
        // Intent intent = new Intent(MainActivity.this, HomeActivity.class);

        // Implicit Way
        Intent intent = new Intent("com.auribises.gw2019android1.homeactivity");
        startActivity(intent);
    }


}
