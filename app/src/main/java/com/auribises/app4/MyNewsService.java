package com.auribises.app4;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class MyNewsService extends IntentService {

    public MyNewsService() {
        super("MyNewsService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        StringBuilder builder;
        Log.i("MyNewsService","==On Handled intent");
        try {
            URL url = new URL(intent.getStringExtra("keyUrl"));
            URLConnection connection = url.openConnection();
            InputStream inputStream =connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            builder = new StringBuilder();
            while ((line=reader.readLine())!=null){
                builder.append(line);
            }
            Log.i("MyNewsService",builder.toString());

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
