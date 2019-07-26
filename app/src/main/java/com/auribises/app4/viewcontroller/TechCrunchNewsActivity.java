package com.auribises.app4.viewcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.auribises.app4.R;
import com.auribises.app4.adapter.NewsAdapter;
import com.auribises.app4.model.TechCrunchNews;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class TechCrunchNewsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ProgressDialog progressDialog;
    StringBuilder builder;
    ArrayList<TechCrunchNews> newsList;
    NewsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_crunch_news);

        getSupportActionBar().setTitle("News");

        listView=findViewById(R.id.listView);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    class FetchNewsTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                URL url = new URL("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=f2cf54a734ee4c6381abc5b57e49b288");
                URLConnection connection = url.openConnection();
                InputStream inputStream =connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line="";
                builder = new StringBuilder();
                while ((line=reader.readLine())!=null){
                    builder.append(line);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            Log.i("TechCrunchNewsActivity",builder.toString());

            parseJSONResponse();

        }

        @Override
        protected void onPreExecute() {
            progressDialog.show();
        }
    }
    void parseJSONResponse(){
        try {
        JSONObject jObj = new JSONObject(builder.toString());
        JSONArray array = jObj.getJSONArray("articles");

        newsList = new ArrayList<>();

        for(int i=0; i<array.length();i++){
            JSONObject obj = array.getJSONObject(i);

                /*String author = obj.getString("author");
                String title = obj.getString("title");
                String urlToImage = obj.getString("urlToImage");
                String publishedAt = obj.getString("publishedAt");*/

            // 3. Meaningful data from JSON Data is represented as an Object in Java
            TechCrunchNews news = new TechCrunchNews();

            news.author = obj.getString("author");
            news.title = obj.getString("title");
            news.url = obj.getString("url");
            news.urlToImage = obj.getString("urlToImage");
            news.publishedAt = obj.getString("publishedAt");

            newsList.add(news);

            Log.i("TechCrunchNewsActivity", news.toString());
        }

        adapter = new NewsAdapter(TechCrunchNewsActivity.this, R.layout.activity_news_list_item, newsList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(TechCrunchNewsActivity.this);
        progressDialog.dismiss();
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
