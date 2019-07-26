package com.auribises.app4.viewcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.auribises.app4.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BooksActivity extends AppCompatActivity {
    StringBuilder builder;
    BooksTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        task = new BooksTask();
        task.execute();
    }
    class BooksTask extends AsyncTask{         // thread in android which will run pARALLELY to the activity
        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                URL url =new URL("https://newsapi.org/v2/everything?q=bitcoin&from=2019-06-23&sortBy=publishedAt&apiKey=f2cf54a734ee4c6381abc5b57e49b288");
                URLConnection connection =url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                builder = new StringBuilder();
                String line="";
                while ((line=reader.readLine())!=null){
                    builder.append(line);
                }
            } catch (Exception e){
                   e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            Toast.makeText(getApplicationContext(), "Response"+builder.toString(), Toast.LENGTH_SHORT).show();
            Log.i("RESPONSE",builder.toString());
        }

        @Override
        protected void onPreExecute() {

        }
    }
}
